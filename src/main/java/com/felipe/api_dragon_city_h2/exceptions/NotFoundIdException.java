package com.felipe.api_dragon_city_h2.exceptions;

public class NotFoundIdException extends RuntimeException {
    public NotFoundIdException() {
        super("ID não encontrado.");
    }

    public NotFoundIdException(String message) {
        super(message);
    }
}
