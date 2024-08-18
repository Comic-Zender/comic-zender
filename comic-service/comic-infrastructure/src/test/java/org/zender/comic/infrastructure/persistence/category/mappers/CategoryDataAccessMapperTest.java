package org.zender.comic.infrastructure.persistence.category.mappers;

import org.junit.jupiter.api.Test;
import org.zender.comic.domain.category.models.Category;
import org.zender.comic.infrastructure.persistence.category.entities.CategoryEntity;
import org.zender.common.domain.valueobjects.category.CategoryId;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CategoryDataAccessMapperTest {
    private static final Long ID = 1L;
    private static final String NAME = "name";
    private static final Instant CREATED_AT = Instant.now();
    private static final Instant UPDATED_AT = Instant.now();

    @Test
    void shouldReturnCategory_whenMapFromEntity() {
        // Arrange
        CategoryEntity entityMock = getEntity();
        // Act
        Category category = CategoryDataAccessMapper.INSTANCE.categoryEntityToCategory(entityMock);
        // Assert
        assertEquals(entityMock.getId(), category.getId().getValue());
        assertEquals(entityMock.getName(), category.getName());
        assertEquals(entityMock.getCreatedAt(), category.getCreatedAt());
        assertEquals(entityMock.getUpdatedAt(), category.getUpdatedAt());
    }

    @Test
    void shouldReturnCategoryEntity_whenMapFromModel() {
        // Arrange
        Category categoryMock = getModel();
        // Act
        CategoryEntity entity = CategoryDataAccessMapper.INSTANCE.categoryToCategoryEntity(categoryMock);
        // Assert
        assertEquals(categoryMock.getId().getValue(), entity.getId());
        assertEquals(categoryMock.getName(), entity.getName());
        assertEquals(categoryMock.getCreatedAt(), entity.getCreatedAt());
        assertEquals(categoryMock.getUpdatedAt(), entity.getUpdatedAt());
    }

    private Category getModel() {
        return Category.builder()
                .id(new CategoryId(ID))
                .name(NAME)
                .createdAt(CREATED_AT)
                .updatedAt(UPDATED_AT)
                .build();
    }

    private CategoryEntity getEntity() {
        return CategoryEntity.builder()
                .id(ID)
                .name(NAME)
                .createdAt(CREATED_AT)
                .updatedAt(UPDATED_AT)
                .build();
    }
}
