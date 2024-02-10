package fr.jouhs.demohexagonalarchitecture.infrastructure.exceptions;

public class MovieAlreadyExistsException extends RuntimeException{
    public MovieAlreadyExistsException(String message) {
        super(message);
    }
}
