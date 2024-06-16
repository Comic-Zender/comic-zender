package org.zender.comicdomain.author.models;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.zender.comicdomain.author.valueobjects.AuthorId;
import org.zender.commondomain.models.BaseEntity;

import java.time.Instant;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Builder
public class Author extends BaseEntity<AuthorId> {
    private String name;
    private Date dateOfBirth;
    private Instant createdAt;
    private Instant updatedAt;
}
