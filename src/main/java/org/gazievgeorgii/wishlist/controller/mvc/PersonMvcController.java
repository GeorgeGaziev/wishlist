package org.gazievgeorgii.wishlist.controller.mvc;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.gazievgeorgii.wishlist.business.PersonManager;
import org.gazievgeorgii.wishlist.business.WishManager;
import org.gazievgeorgii.wishlist.domain.Person;
import org.gazievgeorgii.wishlist.domain.Wish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/persons")
@Slf4j
public class PersonMvcController {
    @Autowired
    private PersonManager personManager;

    @Autowired
    private WishManager wishManager;

    @GetMapping
    public String personsPage(Model model) {
        model.addAttribute("persons", personManager.findAll());
        return "persons";
    }

    @GetMapping("/add")
    public String addPostPage(Model model) {
        model.addAttribute("person", new Person());
        return "addPerson";
    }

    @GetMapping("/{personId}/wishes/add")
    public String addWishPage(Model model, @PathVariable Long personId) {
        model.addAttribute("wish", new Wish());
        model.addAttribute("personId", personId);
        return "addWish";
    }

    @PostMapping
    public String addPost(@ModelAttribute("post") @Valid Person person, Errors errors) {
        if (errors.hasErrors()) {
            return "addPost";
        }
        personManager.addPerson(person);
        log.info("Created person with id " + person.getId());
        return "redirect:/persons";
    }

    @PostMapping("/{personId}/wishes/add")
    public String addWish(@ModelAttribute("wish") @Valid Wish wish,
                          @PathVariable Long personId, Errors errors) {
        if (errors.hasErrors()) {
            return "addWish";
        }
        wishManager.addWishToPerson(wish, personId);
        log.info("Created wish with id " + wish.getId());
        return "redirect:/persons";
    }
}
