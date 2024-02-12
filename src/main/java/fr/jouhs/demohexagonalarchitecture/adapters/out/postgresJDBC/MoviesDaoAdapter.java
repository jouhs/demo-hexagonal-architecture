package fr.jouhs.demohexagonalarchitecture.adapters.out.postgresJDBC;

import fr.jouhs.demohexagonalarchitecture.adapters.out.postgresJDBC.entities.MovieEntity;
import fr.jouhs.demohexagonalarchitecture.adapters.out.postgresJDBC.repositories.MoviesRepository;
import fr.jouhs.demohexagonalarchitecture.application.dao.MovieDAO;
import fr.jouhs.demohexagonalarchitecture.application.dto.NewMovieDto;
import fr.jouhs.demohexagonalarchitecture.domain.Movie;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class MoviesDaoAdapter implements MovieDAO {
    private final MoviesRepository moviesRepository;
    @Override
    public Optional<Movie> findMovieByTitle(String title) {
        return moviesRepository.findMovieByTitle(title);
    }

    @Override
    public List<Movie> findAllMovies() {
        var movies = ((List<MovieEntity>) moviesRepository.findAll())
                .stream()
                .map(movieEntity -> new Movie(
                        movieEntity.id(),
                        movieEntity.title(),
                        movieEntity.description(),
                        movieEntity.releaseDate(),
                        movieEntity.directorName()))
                .toList();
        return movies;
    }

    @Override
    public void saveMovie(NewMovieDto newMovie) {
        var movieEntity = new MovieEntity(
                null,
                newMovie.title(),
                newMovie.description(),
                newMovie.releaseDate(),
                newMovie.directorName(),
                null
        );
        moviesRepository.save(movieEntity);

    }

    @Override
    public void updateMovie(Movie newMovie) {
        var movieEntity = new MovieEntity(
                newMovie.id(),
                newMovie.title(),
                newMovie.description(),
                newMovie.releaseDate(),
                newMovie.directorName(),
                null
        );
        moviesRepository.save(movieEntity);
    }

    @Override
    public void deleteMovie(Movie oldMovie) {
        moviesRepository.deleteById(oldMovie.id());
    }
}
