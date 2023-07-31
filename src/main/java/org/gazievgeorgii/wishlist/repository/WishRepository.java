package org.gazievgeorgii.wishlist.repository;

import org.gazievgeorgii.wishlist.domain.Wish;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WishRepository extends CrudRepository<Wish, Long> {
    List<Wish> findAll();

    default Wish findByIdExact(Long id) {
        return findById(id)
                .orElseThrow(() -> new RuntimeException("Failed to find a wish with id [" + id + "]"));
    }

    List<Wish> findByOwnerId(Long ownerId);

    Optional<Wish> findByOwnerIdAndId(Long ownerId, Long Id);

}
