package com.shreeya.user.services.impl;


import com.shreeya.user.entities.Hotel;
import com.shreeya.user.entities.Rating;
import com.shreeya.user.entities.User;
import com.shreeya.user.exceptions.ResourceNotFoundException;
import com.shreeya.user.external.services.HotelService;
import com.shreeya.user.repositories.UserRepository;
import com.shreeya.user.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

//to treate this class as service, we use service notation
@Service
public class UserServiceImpl implements UserService {


    //we need repository to save in database

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private HotelService hotelService;

    @Autowired
    private RestTemplate restTemplate;


    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        //generate unique userid
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {

        //as we did in getUser(userId), we can implement RATING SERVICE CALL: USING REST TEMPLATE

        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(()->
                new ResourceNotFoundException("User with given id is not found on server !!: " + userId));
     //fetch rating of the above user from RATING SERVICE

        // the problem here is that we are using hardcoded url which is not recommended as when we will deploy our
        //application on different environments, we will be deploying on different server ips as well as the port, so its
        //better to make url as a dynamic key and calling different service by name is a good practice as
        // name will never change irrespective of the environment
       Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Rating[].class);
        logger.info("{} ",ratingsOfUser);

        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();
        List<Rating> ratingList = ratings.stream().map(rating -> {
            //api call to hotel service to get the hotel

           // http://localhost:8082/hotels/45d2ab40-4609-43f0-99d1-53859120910e

            //ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/" + rating.getHotelId(), Hotel.class);
            //Hotel hotel = hotelService.getHotel(rating.getHotelId());
           // rating.setHotel(hotel);

            return rating;
            //set the hotel to rating
            //return the rating
            //return rating;

        }).collect(Collectors.toList());


        user.setRatings(ratingList);

        return  user;

    }

    @Override
    public int deleteUser(String userId) {
        return 0;
    }

    @Override
    public int updateUser(String userId) {
        return 0;
    } //giving error as we have not implemented interface methods


}
