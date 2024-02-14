package services;


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




}
