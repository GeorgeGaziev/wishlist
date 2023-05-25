package org.gazievgeorgii.wishlist;

import org.gazievgeorgii.wishlist.business.PersonManager;
import org.gazievgeorgii.wishlist.business.WishManager;
import org.gazievgeorgii.wishlist.domain.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PersonManagerTest {

    @Autowired
    private PersonManager personManager;

    @Autowired
    private WishManager wishManager;

    @Test
    public void addPersonTest() {
        int initialSize = personManager.findAll().size();
        personManager.addMockPerson();
        assertThat(personManager.findAll()).hasSize(initialSize + 1);
    }

    @Test
    public void getAllPersonsTest() {
        assertThat(personManager.findAll().size()).isGreaterThan(0);
    }

    @Test
    public void updatePersonTest() {
        Person person = personManager.addMockPerson();
        person.setFirstname("Updated firstname for " + person.getId());
        person.setLastname("Updated lastname for " + person.getId());
        Person updatedPerson = personManager.updatePerson(person);

        assertThat(updatedPerson.getFirstname()).isEqualTo(person.getFirstname());
        assertThat(updatedPerson.getLastname()).isEqualTo(person.getLastname());
        assertThat(updatedPerson.getBirthday()).isEqualTo(person.getBirthday());
        assertThat(updatedPerson.getId()).isEqualTo(person.getId());
        assertThat(updatedPerson.getWishes()).hasSameElementsAs(person.getWishes());
    }
}
