package org.gazievgeorgii.wishlist.repository.exceptions;

public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
