package org.zender.common.infrastructure.entities;


import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(value = AuditingEntityListener.class)
public abstract class BasePersistEntity {
    @CreatedDate
    @Column(insertable = false, updatable = false)
    private Instant createdAt;
    @LastModifiedDate
    private Instant updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof BasePersistEntity that)) return false;

        return new EqualsBuilder().append(createdAt, that.createdAt).append(updatedAt, that.updatedAt).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(createdAt).append(updatedAt).toHashCode();
    }
}
