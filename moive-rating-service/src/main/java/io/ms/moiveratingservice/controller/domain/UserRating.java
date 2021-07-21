package io.ms.moiveratingservice.controller.domain;

import java.util.List;

public class UserRating {

    private List<Rating> UserRatings;


    public void setUserRatings(List<Rating> userRatings) {
        UserRatings = userRatings;
    }

    public List<Rating> getUserRatings() {
        return UserRatings;
    }
}
