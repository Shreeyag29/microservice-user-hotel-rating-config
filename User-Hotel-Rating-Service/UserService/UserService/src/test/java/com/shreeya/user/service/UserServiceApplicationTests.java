package com.shreeya.user.service;

import com.shreeya.user.entities.Rating;
import com.shreeya.user.external.services.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}

//	@Autowired
//	private RatingService ratingService;


//	@Test
//	void createRating(){
//		Rating rating = Rating.builder().rating(10).userId("").hotelId("")
//				.feedback("This is created using feign client").build(); //setting parameters before build
//        Rating savedRating = ratingService.createRating(rating);
//		System.out.println("new rating created");
//
//	}

}
