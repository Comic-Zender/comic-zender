package org.zender.comicdomain.comic.models;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.zender.comicdomain.author.valueobjects.AuthorId;
import org.zender.comicdomain.category.valueobjects.CategoryId;
import org.zender.comicdomain.comic.valueobjects.ComicId;
import org.zender.commondomain.models.BaseAggregateRoot;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Builder
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
