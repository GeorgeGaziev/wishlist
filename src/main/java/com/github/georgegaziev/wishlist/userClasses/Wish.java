package com.github.georgegaziev.wishlist.userClasses;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

/**
 * @author g.gaziev (g.gaziev@itfbgroup.ru)
 */
@Entity
@Getter
@Setter
public class Wish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String description;
    private boolean taken;

    public Wish(String description) {
        this.description = description;
        this.taken = false;
    }

    public Wish() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wish wish = (Wish) o;
        return id == wish.id &&
                taken == wish.taken &&
                Objects.equals(description, wish.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, taken);
    }
}
