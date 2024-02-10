package fr.jouhs.demohexagonalarchitecture.application.dao;

import fr.jouhs.demohexagonalarchitecture.application.dto.NewMovieDto;
import fr.jouhs.demohexagonalarchitecture.domain.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieDAO {
    Optional<Movie> findMovieByTitle(String title);
    List<Movie> findAllMovies();
    void saveMovie(NewMovieDto newMovie);
    void updateMovie(Movie newMovie);
    void deleteMovie(Movie oldMovie);
}
