package org.gazievgeorgii.wishlist;

import org.gazievgeorgii.wishlist.business.PersonManager;
import org.gazievgeorgii.wishlist.business.WishManager;
import org.gazievgeorgii.wishlist.domain.Person;
import org.gazievgeorgii.wishlist.domain.Wish;
import org.gazievgeorgii.wishlist.domain.WishStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class WishManagerTest {

    @Autowired
    private PersonManager personManager;

    @Autowired
    private WishManager wishManager;

    @Test
    public void createWishTest() {
        Person mockPerson = personManager.addMockPerson();
        Wish wish = wishManager.addMockWishToPerson(mockPerson);
        assertThat(wish.getId()).isNotNull();
        assertThat(wish.getOwner()).isEqualTo(mockPerson);
        assertThat(wish.getStatus()).isEqualTo(WishStatus.NEW);
        assertThat(wish.getUpdatedOn()).isNotNull();
        assertThat(wish.getCreatedOn()).isNotNull();
    }

    @Test
    public void updateWishTest(){
        Person mockPerson = personManager.addMockPerson();
        Wish wish = wishManager.addMockWishToPerson(mockPerson);
        LocalDateTime initialUpdateTime = LocalDateTime.now();

        WishStatus updatedStatus = WishStatus.TAKEN;
        String updatedDescription = "Updated description " + System.currentTimeMillis();
        String updatedComment = "Updated comment " + System.currentTimeMillis();

        wish.setStatus(updatedStatus);
        wish.setDescription(updatedDescription);
        wish.setComment(updatedComment);

        wishManager.updateWish(wish);
        Wish updatedWish = wishManager.findById(wish.getId());
        assertThat(updatedWish.getStatus()).isEqualTo(updatedStatus);
        assertThat(updatedWish.getDescription()).isEqualTo(updatedDescription);
        assertThat(updatedWish.getComment()).isEqualTo(updatedComment);
        assertThat(updatedWish.getUpdatedOn()).isAfter(initialUpdateTime);
    }
}
