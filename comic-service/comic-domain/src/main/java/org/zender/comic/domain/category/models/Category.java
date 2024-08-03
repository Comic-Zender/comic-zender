package org.zender.comic.domain.category.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.zender.comic.domain.category.valueobjects.CategoryId;
import org.zender.common.domain.models.BaseAggregateRoot;

import java.time.Instant;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class Category extends BaseAggregateRoot<CategoryId> {
    private String name;
    private Instant createdAt;
    private Instant updatedAt;
}
