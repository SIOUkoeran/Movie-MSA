package io.ms.moiveratingservice.controller;


import io.ms.moiveratingservice.controller.domain.Rating;
import io.ms.moiveratingservice.controller.domain.UserRating;
import org.springframework.boot.env.RandomValuePropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingController {


    @GetMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId")String movieId){
        return new Rating(movieId, 4);
    }
    @RequestMapping("/users/{userId}")
    public UserRating getRatingByUser(@PathVariable("userId") String userId){
        List<Rating> ratingList=  Arrays.asList(
                new Rating("550",4),
                new Rating("100",3)
        );
        UserRating userRating = new UserRating();
        userRating.setUserRatings(ratingList);
        return userRating ;
    }
}
