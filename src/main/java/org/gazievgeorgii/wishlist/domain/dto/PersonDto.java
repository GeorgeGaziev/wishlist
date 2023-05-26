package org.gazievgeorgii.wishlist.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.gazievgeorgii.wishlist.domain.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class PersonDto {
    private Long id;
    private String firstname;
    private String lastname;
    private LocalDate birthday;
    private List<WishDto> wishes = new ArrayList<>();

    public Person toPersonEntity() {
        Person entity = new Person();
        entity.setId(this.getId());
        entity.setFirstname(this.getFirstname());
        entity.setLastname(this.getLastname());
        entity.setBirthday(this.getBirthday());
        entity.setWishes(this.getWishes().stream().map(WishDto::toWishEntity).collect(Collectors.toList()));
        return entity;
    }

    public PersonDto(Person entity) {
        this.id = entity.getId();
        this.firstname = entity.getFirstname();
        this.lastname = entity.getLastname();
        this.birthday = entity.getBirthday();
        this.wishes = entity.getWishes().stream().map(WishDto::new).collect(Collectors.toList());
    }
}
