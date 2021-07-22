package io.ms.movieinfoservice.controller;


import io.ms.movieinfoservice.domain.Movie;
import io.ms.movieinfoservice.domain.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;


@RestController
@RequestMapping("/movies")
public class MovieInfoController {

    @Value("${api.key}")
    private String apiKey;


    private final WebClient.Builder WebClientBuilder;

    @Autowired
    public MovieInfoController(WebClient.Builder webClientBuilder) {
        WebClientBuilder = webClientBuilder;
    }

    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId){
        MovieSummary movieSummary = WebClientBuilder.build()
                .get()
                .uri("https://api.themoviedb.org/3/movie/" + movieId+ "?api_key="+apiKey)
                .retrieve()
                .bodyToMono(MovieSummary.class)
                .block();


        return new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());
    }
}
