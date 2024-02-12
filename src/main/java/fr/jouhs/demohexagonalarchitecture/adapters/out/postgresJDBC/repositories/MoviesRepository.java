package fr.jouhs.demohexagonalarchitecture.adapters.out.postgresJDBC.repositories;

import fr.jouhs.demohexagonalarchitecture.adapters.out.postgresJDBC.entities.MovieEntity;
import fr.jouhs.demohexagonalarchitecture.domain.Movie;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface MoviesRepository extends CrudRepository<MovieEntity, Long> {
    @Query("select * from movies where title =:title")
    Optional<Movie> findMovieByTitle(@Param("title") String title);
}
