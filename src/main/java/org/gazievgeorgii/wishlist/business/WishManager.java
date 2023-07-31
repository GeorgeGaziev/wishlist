package org.gazievgeorgii.wishlist.business;

import lombok.extern.slf4j.Slf4j;
import org.gazievgeorgii.wishlist.domain.Person;
import org.gazievgeorgii.wishlist.domain.Wish;
import org.gazievgeorgii.wishlist.domain.WishStatus;
import org.gazievgeorgii.wishlist.repository.PersonRepository;
import org.gazievgeorgii.wishlist.repository.WishRepository;
import org.gazievgeorgii.wishlist.repository.exceptions.WishNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Wish findByOwnerIdAndWishId(Long ownerId, Long wishId) {
        return wishRepository.findByOwnerIdAndId(ownerId, wishId).orElseThrow(() -> new WishNotFoundException("Failed to find a wish with id [" + wishId + "] from user [" + ownerId + "]"));
    }

    public Wish addWishToPerson(Wish wish, Long personId) {
        Person owner = personRepository.findByIdExact(personId);
        wish.setOwner(owner);
        wish.setStatus(WishStatus.NEW);
        wish.setCreatedOn(LocalDateTime.now());
        wish.setUpdatedOn(LocalDateTime.now());
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

    public Wish updateWishById(Wish wish, Long personId, Long wishId) {
        Wish savedWish = findByOwnerIdAndWishId(personId, wishId);
        savedWish.setStatus(wish.getStatus());
        savedWish.setDescription(wish.getDescription());
        savedWish.setComment(wish.getComment());
        savedWish.setUpdatedOn(LocalDateTime.now());
        return wishRepository.save(savedWish);
    }

    public List<Wish> findByOwnerId(Long personId) {
        return wishRepository.findByOwnerId(personId);
    }

    public void deleteWish(Long personId, Long wishId) {
        var wish = findByOwnerIdAndWishId(personId, wishId);
        wishRepository.delete(wish);
    }
}
