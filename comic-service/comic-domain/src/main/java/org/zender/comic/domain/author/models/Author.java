package org.zender.comic.domain.author.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.zender.common.domain.valueobjects.author.AuthorId;
import org.zender.common.domain.models.BaseEntity;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class Author extends BaseEntity<AuthorId> {
    private String name;
    private LocalDate dateOfBirth;
    private Instant createdAt;
    private Instant updatedAt;
}
