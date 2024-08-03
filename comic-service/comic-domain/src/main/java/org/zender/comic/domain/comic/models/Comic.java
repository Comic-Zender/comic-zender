package org.zender.comic.domain.comic.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.zender.common.domain.valueobjects.author.AuthorId;
import org.zender.common.domain.valueobjects.category.CategoryId;
import org.zender.common.domain.valueobjects.comic.ComicId;
import org.zender.common.domain.models.BaseAggregateRoot;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class Comic extends BaseAggregateRoot<ComicId> {
    private String name;
    private String description;
    private String posterUrl;
    private AuthorId authorId;
    private Boolean isCompleted;
    private List<CategoryId> categories;
    private Instant createdAt;
    private Instant updatedAt;
}