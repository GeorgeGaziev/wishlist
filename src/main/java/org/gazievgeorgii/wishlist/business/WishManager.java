package org.gazievgeorgii.wishlist.business;

import lombok.extern.slf4j.Slf4j;
import org.gazievgeorgii.wishlist.domain.Person;
import org.gazievgeorgii.wishlist.domain.Wish;
import org.gazievgeorgii.wishlist.domain.WishStatus;
import org.gazievgeorgii.wishlist.repository.WishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class WishManager {

    @Autowired
    private WishRepository wishRepository;

    @Transactional
    public Wish addMockWishToPerson(Person person) {
        log.info("About to add a wish..");
        Wish wish = new Wish();
        wish.setOwner(person);
        wish.setDescription("Testing wish description " + System.currentTimeMillis());
        wish.setComment("Testing wish comment " + System.currentTimeMillis());
        wish.setStatus(WishStatus.NEW);
        wish.setCreatedOn(LocalDateTime.now());
        wish.setUpdatedOn(LocalDateTime.now());
        return wishRepository.save(wish);
    }

    @Transactional
    public List<Wish> findAll() {
        return wishRepository.findAll();
    }
}
