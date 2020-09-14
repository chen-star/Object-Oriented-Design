package moviebooking;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : alexchen
 * @created : 9/13/20, Sunday
 **/
@ToString
@Getter
public class MovieDB {

    public static MovieDB instance = new MovieDB();

    private MovieDB() {
        movieMap = new HashMap<>();
        genreMovieMap = new HashMap<>();
    }

    public static MovieDB getInstance() {
        return instance;
    }

    private Map<Integer, Movie> movieMap;

    private Map<Genre, List<Movie>> genreMovieMap;

    public void addMovie(Movie movie) {
        movieMap.put(movie.getMovieId(), movie);
        genreMovieMap.computeIfAbsent(movie.getGenre(), l -> new ArrayList<>())
                .add(movie);
    }
}
