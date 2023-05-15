package org.gazievgeorgii.wishlist;

import org.gazievgeorgii.wishlist.business.PersonManager;
import org.gazievgeorgii.wishlist.business.WishManager;
import org.gazievgeorgii.wishlist.domain.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class WishlistApplicationTests {

    @Autowired
    private PersonManager personManager;

    @Autowired
    private WishManager wishManager;

    @Test
    public void addUserTest() {
        int initialSize = personManager.findAll().size();
        personManager.addUser();
        assertThat(personManager.findAll()).hasSize(initialSize + 1);
    }

    @Test
    public void addWishTest() {
        Long personId = personManager.addUser();
        Person firstPerson = personManager.findById(personId).orElseThrow();
        wishManager.addWishToPerson(firstPerson);
        assertThat(wishManager.findAll()).hasSize(1);
    }
}
