package org.gazievgeorgii.wishlist.controller.mvc;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.gazievgeorgii.wishlist.business.PersonManager;
import org.gazievgeorgii.wishlist.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/person")
@Slf4j
public class PersonMvcController {
    @Autowired
    private PersonManager personManager;

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

    @PostMapping
    public String addPost(@ModelAttribute("post") @Valid Person person, Errors errors) {
        if (errors.hasErrors()) {
            return "addPost";
        }
        personManager.addPerson(person);
        log.info("Created person with id " + person.getId());
        return "redirect:/person";
    }
}
