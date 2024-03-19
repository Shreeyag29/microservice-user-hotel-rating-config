package com.shreeya.rating.repositories;

import com.shreeya.rating.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating,String> {

    //findAll and save methods are provided by MongoRepository by default

    //as we need to find ratings via custom inputs like userId and hotelId, we will
    //write custom methods

    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);


}
