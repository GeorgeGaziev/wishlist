package org.gazievgeorgii.wishlist.controller.rest;

import lombok.extern.slf4j.Slf4j;
import org.gazievgeorgii.wishlist.business.WishManager;
import org.gazievgeorgii.wishlist.domain.dto.WishDto;
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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/persons")
@Slf4j
public class WishController {
    @Autowired
    private WishManager wishManager;

    @PostMapping("/{personId}/wishes")
    @ResponseStatus(HttpStatus.CREATED)
    public WishDto createWish(@RequestBody WishDto wishDto, @PathVariable Long personId) {
        return new WishDto(wishManager.addWishToPerson(wishDto.toWishEntity(), personId));
    }

    @GetMapping("/{personId}/wishes/{wishId}")
    @ResponseStatus(HttpStatus.OK)
    public WishDto getWish(@PathVariable Long personId, @PathVariable Long wishId) {
        return new WishDto(wishManager.findByOwnerIdAndWishId(personId, wishId));
    }

    @GetMapping("/{personId}/wishes")
    @ResponseStatus(HttpStatus.OK)
    public List<WishDto> getWishes(@PathVariable Long personId) {
        return wishManager.findByOwnerId(personId).stream().map(WishDto::new).collect(Collectors.toList());
    }

    @PutMapping("/{personId}/wishes/{wishId}")
    @ResponseStatus(HttpStatus.OK)
    public WishDto updateWish(@RequestBody WishDto wishDto, @PathVariable Long personId, @PathVariable Long wishId) {
        return new WishDto(wishManager.updateWishById(wishDto.toWishEntity(), personId, wishId));
    }

    @DeleteMapping("/{personId}/wishes/{wishId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteWish(@PathVariable Long personId, @PathVariable Long wishId) {
        wishManager.deleteWish(personId, wishId);
    }
}
