package org.zender.comicdomain.category.models;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.zender.comicdomain.category.valueobjects.CategoryId;
import org.zender.commondomain.models.BaseAggregateRoot;

import java.time.Instant;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Builder
public class Category extends BaseAggregateRoot<CategoryId> {
    private String name;
    private Instant createdAt;
    private Instant updatedAt;
}
