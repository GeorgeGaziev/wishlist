package org.gazievgeorgii.wishlist.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.gazievgeorgii.wishlist.domain.Wish;
import org.gazievgeorgii.wishlist.domain.WishStatus;

@Data
@NoArgsConstructor
public class WishDto {
    private Long id;
    private String description;
    private WishStatus status;
    private String comment;

    public Wish toWishEntity() {
        Wish entity = new Wish();
        entity.setId(this.getId());
        entity.setDescription(this.getDescription());
        entity.setStatus(this.getStatus());
        entity.setComment(this.getComment());
        return entity;
    }

    public WishDto(Wish entity) {
        this.id = entity.getId();
        this.description = entity.getDescription();
        this.status = entity.getStatus();
        this.comment = entity.getComment();
    }
}
