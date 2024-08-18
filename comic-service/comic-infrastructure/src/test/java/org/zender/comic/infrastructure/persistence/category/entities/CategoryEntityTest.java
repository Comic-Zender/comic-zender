package org.zender.comic.infrastructure.persistence.category.entities;

import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoryEntityTest {
    private static final Long ID = 1L;
    private static final String NAME = "name";
    private static final Instant CREATED_AT = Instant.now();
    private static final Instant UPDATED_AT = Instant.now();
    private static final Instant DELETED_AT = Instant.now();

    @Test
    void shouldInvolve_whenBuilder() {
        // Act
        CategoryEntity entity = CategoryEntity.builder()
                .id(ID)
                .name(NAME)
                .createdAt(CREATED_AT)
                .updatedAt(UPDATED_AT)
                .deletedAt(DELETED_AT)
                .build();
        // Assert
        assertEquals(ID, entity.getId());
        assertEquals(NAME, entity.getName());
        assertEquals(CREATED_AT, entity.getCreatedAt());
        assertEquals(UPDATED_AT, entity.getUpdatedAt());
        assertEquals(DELETED_AT, entity.getDeletedAt());
    }

    @Test
    void shouldInvolve_whenSetter() {
        // Arrange
        CategoryEntity entityMock = CategoryEntity.builder().build();
        // Act
        entityMock.setId(ID);
        entityMock.setName(NAME);
        entityMock.setCreatedAt(CREATED_AT);
        entityMock.setUpdatedAt(UPDATED_AT);
        entityMock.setDeletedAt(DELETED_AT);
        // Assert
        assertEquals(ID, entityMock.getId());
        assertEquals(NAME, entityMock.getName());
        assertEquals(CREATED_AT, entityMock.getCreatedAt());
        assertEquals(UPDATED_AT, entityMock.getUpdatedAt());
        assertEquals(DELETED_AT, entityMock.getDeletedAt());
    }
}
