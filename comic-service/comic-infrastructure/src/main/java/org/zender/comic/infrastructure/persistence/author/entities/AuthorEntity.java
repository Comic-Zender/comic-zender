package org.zender.comic.infrastructure.persistence.author.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.zender.common.infrastructure.entities.BasePersistEntity;

import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "authors")
@SQLDelete(sql = "UPDATE authors SET deleted_at = current_timestamp WHERE id = ?")
@SQLRestriction(value = "deleted_at IS NULL")
public class AuthorEntity extends BasePersistEntity {

    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @Temporal(TemporalType.TIMESTAMP)
    private Instant deletedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof AuthorEntity that)) return false;

        return new EqualsBuilder().appendSuper(super.equals(o)).append(id, that.id).append(name, that.name).append(dateOfBirth, that.dateOfBirth).append(deletedAt, that.deletedAt).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).appendSuper(super.hashCode()).append(id).append(name).append(dateOfBirth).append(deletedAt).toHashCode();
    }
}
