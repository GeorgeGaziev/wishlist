package org.gazievgeorgii.wishlist.business;

import lombok.extern.slf4j.Slf4j;
import org.gazievgeorgii.wishlist.domain.Person;
import org.gazievgeorgii.wishlist.domain.Wish;
import org.gazievgeorgii.wishlist.domain.WishStatus;
import org.gazievgeorgii.wishlist.repository.PersonRepository;
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

    @Autowired
    private PersonRepository personRepository;

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

    public List<Wish> findAll() {
        return wishRepository.findAll();
    }

    public Wish findById(Long id) {
        return wishRepository.findByIdExact(id);
    }

    public Wish addWishToPerson(Wish wish, Long personId) {
        Person owner = personRepository.findByIdExact(personId);
        wish.setOwner(owner);
        return wishRepository.save(wish);
    }

    public Wish updateWish(Wish wish) {
        Wish savedWish = wishRepository.findByIdExact(wish.getId());
        savedWish.setStatus(wish.getStatus());
        savedWish.setDescription(wish.getDescription());
        savedWish.setComment(wish.getComment());

        savedWish.setUpdatedOn(LocalDateTime.now());
        return wishRepository.save(savedWish);
    }

    public void deleteWish(Long wishId) {
        wishRepository.deleteById(wishId);
    }
}
