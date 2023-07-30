package org.gazievgeorgii.wishlist.repository.advices;

import org.gazievgeorgii.wishlist.repository.exceptions.WishNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class WishNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(WishNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String personNotFoundHandler(WishNotFoundException ex) {
        return ex.getMessage();
    }

}
