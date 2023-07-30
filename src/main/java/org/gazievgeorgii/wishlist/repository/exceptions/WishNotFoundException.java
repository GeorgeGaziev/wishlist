package org.gazievgeorgii.wishlist.repository.exceptions;

public class WishNotFoundException extends RuntimeException {
    public WishNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
