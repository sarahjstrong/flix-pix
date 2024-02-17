package services;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.model.Movie;
import com.techelevator.model.MovieAPIDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.List;

@Component
public class OMDBService {

    @Value("${api.url}")
    private String apiURL;

    @Value("${api.key}")
    private String key;

    private final RestTemplate restTemplate = new RestTemplate();

    public MovieAPIDTO getMovieFromAPI(String imdbId) {
        MovieAPIDTO output = null;

        try{
            output = restTemplate.getForObject(apiURL+ "?i=" + imdbId + key, MovieAPIDTO.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return output;
    }


//    public List<Movie> OMDBAPICall(String searchString) {
//
//        String url = this.apiURL + this.key + "&s=" + searchString;
//
//        HttpEntity<String> httpEntity = new HttpEntity<>("");
//        RestTemplate restTemplate1 = new RestTemplate();
//        ObjectMapper objectMapper = new ObjectMapper();
//        JsonNode jsonNode;
//        List<Movie> newMovie = new ArrayList<>();
//        ResponseEntity<String> response = restTemplate1.exchange(url, HttpMethod.GET, httpEntity, String.class);
//        System.out.println(response.getBody());
//        try {
//            jsonNode = objectMapper.readTree(response.getBody());
//            JsonNode root = jsonNode.path("Data");
//
//            for (int i = 0; i < root.size(); i++) {
//                int movieId = 1;
//                String title = root.path(i).path("title").asText();
//                int releaseYear = root.path(i).path("Year").asInt();
//                int genreId = 1;
//                Double rating = root.path(i).path("imdbRating").asDouble();
//                String director = root.path(i).path("Director").asText();
//                String imdbID = root.path(i).path("imdbID").asText();
//                String poster = root.path(i).path("Poster").asText();
//
//                Movie movie = new Movie(movieId, title, releaseYear, genreId, rating, director);
//                newMovie.add(movie);
//
//
//            }
//
//
//        } catch (JsonProcessingException e) {
//
//        }
//
//        return newMovie;
//    }








}
