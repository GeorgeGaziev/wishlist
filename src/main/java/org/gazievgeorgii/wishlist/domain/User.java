package org.gazievgeorgii.wishlist.domain;

import java.time.LocalDate;
import java.util.List;

public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private List<Wish> wishList;
}
