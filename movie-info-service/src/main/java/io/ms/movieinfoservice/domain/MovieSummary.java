package io.ms.movieinfoservice.domain;



public class MovieSummary {
    private String title;
    private String movieId;
    private String overview;

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    private genre[] genres;
    private boolean adult;
    private String homepage;
    private int budget;
    private int popularity;
    private production[] productions;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static class genre {
        private int id;
        private String genre;
    }

    public static class production {
        private int id;
        private String logoPath;
        private String name;
        private String originCountry;


    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public genre[] getGenres() {
        return genres;
    }

    public void setGenres(genre[] genres) {
        this.genres = genres;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public production[] getProductions() {
        return productions;
    }

    public void setProductions(production[] productions) {
        this.productions = productions;
    }
}
