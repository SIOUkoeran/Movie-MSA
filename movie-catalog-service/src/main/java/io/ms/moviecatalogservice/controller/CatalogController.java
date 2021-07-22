package io.ms.moviecatalogservice.controller;


import io.ms.moviecatalogservice.domain.CatalogItem;

import io.ms.moviecatalogservice.domain.Movie;
import io.ms.moviecatalogservice.domain.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class CatalogController {



    private final RestTemplate restTemplate;
    private final WebClient.Builder webClientBuilder;

    @Autowired
    public CatalogController(RestTemplate restTemplate, WebClient.Builder webClientBuilder) {
        this.restTemplate = restTemplate;
        this.webClientBuilder = webClientBuilder;
    }

    WebClient.Builder builder = WebClient.builder();
    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userid){

        RestTemplate restTemplate = new RestTemplate();

        //get all rated movie Ids
//        List<Rating> ratings = Arrays.asList(
//                new Rating("1234",4),
//                new Rating("5678",3)
//        );
//
        //UserRating ratings = restTemplate.getForObject("http://localhost:8081/ratingsdata/users/" + userid, UserRating.class);
        UserRating ratings = webClientBuilder.build()
                .get()
                .uri("http://rating-datas-service/ratingsdata/users/" + userid)
                .retrieve()
                .bodyToMono(UserRating.class)
                .block();


        // For Each movieId, call movie info service and get details
        return ratings.getUserRatings().stream().map(r->{
            //Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + r.getMovieId(), Movie.class);

            Movie movie = webClientBuilder.build()
                    .get()
                    .uri("localhost://movie-info-service/movies/" + r.getMovieId().toString())
                    .retrieve()
                    .bodyToMono(Movie.class)
                    .block();


            return new CatalogItem(movie.getName(),  movie.getSummary(), r.getRating());
        }).collect(Collectors.toList());

        //put them all together
//        return Collections.singletonList(
//                new CatalogItem(userid, "Test",4)qqq
//        );
    }
}
