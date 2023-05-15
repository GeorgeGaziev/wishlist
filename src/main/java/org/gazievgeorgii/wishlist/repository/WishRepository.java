package org.gazievgeorgii.wishlist.repository;

import org.gazievgeorgii.wishlist.domain.Wish;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishRepository extends CrudRepository<Wish, Long> {
    List<Wish> findAll();
}
