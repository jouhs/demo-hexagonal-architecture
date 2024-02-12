package fr.jouhs.demohexagonalarchitecture.adapters.in.web;

import fr.jouhs.demohexagonalarchitecture.application.dto.NewMovieDto;
import fr.jouhs.demohexagonalarchitecture.application.usecases.MovieUseCases;
import fr.jouhs.demohexagonalarchitecture.domain.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MoviesController {
    private final MovieUseCases movieUseCases;

    @GetMapping
    public ResponseEntity<?> getAllMovies(){
        return ResponseEntity.ok(movieUseCases.getAllMovies());
    }

    @GetMapping("/{title}")
    public ResponseEntity<?> getMovieByTitle(@PathVariable("title") String title){
        return ResponseEntity.ok(movieUseCases.getMovieByTitle(title));
    }

    @PostMapping
    public ResponseEntity<?> saveMovie(@RequestBody NewMovieDto movieDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(movieUseCases.saveMovie(movieDto));
    }

    @PutMapping
    public ResponseEntity<?> updateMovie(@RequestBody Movie movie){
        return ResponseEntity.status(HttpStatus.CREATED).body(movieUseCases.updateMovie(movie));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteMovie(@RequestBody Movie movie){
        return ResponseEntity.status(HttpStatus.CREATED).body(movieUseCases.deleteMovie(movie));
    }
}
