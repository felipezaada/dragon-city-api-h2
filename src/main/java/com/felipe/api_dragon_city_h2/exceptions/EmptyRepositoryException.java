package com.felipe.api_dragon_city_h2.exceptions;

public class EmptyRepositoryException extends RuntimeException {
    public EmptyRepositoryException() {
        super("Repositório vazio.");
    }

    public EmptyRepositoryException(String message) {
        super(message);
    }
}
