package fr.jouhs.demohexagonalarchitecture.application.usecases;

import fr.jouhs.demohexagonalarchitecture.application.dao.MovieDAO;
import fr.jouhs.demohexagonalarchitecture.application.dto.NewMovieDto;
import fr.jouhs.demohexagonalarchitecture.domain.Movie;
import fr.jouhs.demohexagonalarchitecture.infrastructure.exceptions.MovieAlreadyExistsException;
import fr.jouhs.demohexagonalarchitecture.infrastructure.exceptions.MovieNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class MovieUseCases {
    private final MovieDAO movieDAO;
    public String saveMovie(NewMovieDto newMovieDto) throws MovieAlreadyExistsException {
        // check if the movie is already exist in DB
        var isPresent = movieDAO.findMovieByTitle(newMovieDto.title()).isPresent();
        if(isPresent)
            throw new MovieAlreadyExistsException("Movie already exist");

        movieDAO.saveMovie(newMovieDto);

        return "Movie Saved Successfully";
    }

    public List<Movie> getAllMovies() {
        return movieDAO.findAllMovies();
    }

    public String updateMovie(Movie movie) {
        var isPresent = movieDAO.findMovieByTitle(movie.title()).isPresent();
        if(!isPresent)
            throw new MovieNotFoundException("This movie does not exist");

        movieDAO.updateMovie(movie);
        return "Movie Successfully updated";
    }

    public Movie getMovieByTitle(String title) {
        return movieDAO.findMovieByTitle(title).orElseThrow(
                ()-> new MovieNotFoundException("This movie does not exist")
        );
    }

    public String deleteMovie(Movie movie) {
        var isPresent = movieDAO.findMovieByTitle(movie.title()).isPresent();
        if(!isPresent)
            throw new MovieNotFoundException("This movie does not exist");

        movieDAO.deleteMovie(movie);
        return "Movie Successfully deleted";
    }
}
