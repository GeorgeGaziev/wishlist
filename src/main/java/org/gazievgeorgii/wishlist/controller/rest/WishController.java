package org.gazievgeorgii.wishlist.controller.rest;

import org.gazievgeorgii.wishlist.business.WishManager;
import org.gazievgeorgii.wishlist.domain.Wish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class WishController {
    @Autowired
    private WishManager wishManager;

    @PostMapping("/{personId}/wishes")
    @ResponseStatus(HttpStatus.CREATED)
    public Wish createWish(@RequestBody Wish wish, @PathVariable Long personId) {
        return wishManager.addWishToPerson(wish, personId);
    }

    @GetMapping("/{personId}/wishes/{wishId}")
    @ResponseStatus(HttpStatus.OK)
    public Wish getWish(@PathVariable Long wishId) {
        return wishManager.findById(wishId);
    }

    @GetMapping("/{personId}/wishes")
    @ResponseStatus(HttpStatus.OK)
    public List<Wish> getWishes() {
        return wishManager.findAll();
    }

    @PutMapping("/{personId}/wishes")
    @ResponseStatus(HttpStatus.OK)
    public Wish updateWish(@RequestBody Wish wish, @PathVariable Long personId) {
        return wishManager.updateWish(wish);
    }

    @DeleteMapping("/{personId}/wishes/{wishId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteWish(@PathVariable Long wishId) {
        wishManager.deleteWish(wishId);
    }
}
