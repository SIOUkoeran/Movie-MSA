package io.ms.moviecatalogservice.domain;

import java.util.List;

public class UserRating {

    private List<Rating> UserRatings;
    public UserRating(){

    }

    public void setUserRatings(List<Rating> userRatings) {
        UserRatings = userRatings;
    }

    public List<Rating> getUserRatings() {
        return UserRatings;
    }
}
