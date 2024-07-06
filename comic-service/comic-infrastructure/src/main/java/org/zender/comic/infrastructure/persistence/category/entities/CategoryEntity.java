package org.zender.comic.infrastructure.persistence.category.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories")
@SQLDelete(sql = "UPDATE FROM categories SET deleted_at = current_timestamp WHERE id = ?")
@SQLRestriction(value = "deleted_at <> NULL")
public class CategoryEntity extends BasePersistEntity {
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    private Instant deletedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof CategoryEntity that)) return false;

        return new EqualsBuilder().appendSuper(super.equals(o)).append(id, that.id).append(name, that.name).append(deletedAt, that.deletedAt).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).appendSuper(super.hashCode()).append(id).append(name).append(deletedAt).toHashCode();
    }
}
