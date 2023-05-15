package org.gazievgeorgii.wishlist.business;

import lombok.extern.slf4j.Slf4j;
import org.gazievgeorgii.wishlist.domain.Person;
import org.gazievgeorgii.wishlist.domain.Wish;
import org.gazievgeorgii.wishlist.domain.WishStatus;
import org.gazievgeorgii.wishlist.repository.WishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class WishManager {

    @Autowired
    private WishRepository wishRepository;

    @Transactional
    public Long addWishToPerson(Person person) {
        log.info("About to add a wish..");
        Wish wish = new Wish();
        wish.setOwner(person);
        wish.setDescription("Testing wish description");
        wish.setComment("Testing wish comment");
        wish.setStatus(WishStatus.NEW);
        return wishRepository.save(wish).getId();
    }

    @Transactional
    public List<Wish> findAll() {
        return wishRepository.findAll();
    }
}
