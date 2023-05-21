package org.gazievgeorgii.wishlist;

import org.gazievgeorgii.wishlist.business.PersonManager;
import org.gazievgeorgii.wishlist.business.WishManager;
import org.gazievgeorgii.wishlist.domain.Person;
import org.gazievgeorgii.wishlist.domain.Wish;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class WishManagerTest {

    @Autowired
    private PersonManager personManager;

    @Autowired
    private WishManager wishManager;

    @Test
    public void addWishTest() {
        Person firstPerson = personManager.addMockPerson();
        Wish wish = wishManager.addMockWishToPerson(firstPerson);
        assertThat(wish.getId()).isNotNull();
        assertThat(wish.getOwner()).isEqualTo(firstPerson);
        assertThat(wish.getUpdatedOn()).isNotNull();
        assertThat(wish.getCreatedOn()).isNotNull();
        assertThat(wishManager.findAll()).hasSize(1);
    }
}
