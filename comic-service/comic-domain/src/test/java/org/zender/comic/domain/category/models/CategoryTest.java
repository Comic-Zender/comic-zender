package org.zender.comic.domain.category.models;

import org.junit.jupiter.api.Test;
import org.zender.common.domain.valueobjects.category.CategoryId;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryTest {
    private static final Long ID = 1L;
    private static final String NAME = "name";
    private static final Instant CREATED_AT = Instant.now();
    private static final Instant UPDATED_AT = Instant.now();

    @Test
    void shouldInvolve_whenBuilder() {
        // Act
        Category category = Category.builder()
                .id(new CategoryId(ID))
                .name(NAME)
                .createdAt(CREATED_AT)
                .updatedAt(UPDATED_AT)
                .build();
        // Assert
        assertEquals(ID, category.getId().getValue());
        assertEquals(NAME, category.getName());
        assertEquals(CREATED_AT, category.getCreatedAt());
        assertEquals(UPDATED_AT, category.getUpdatedAt());
    }

    @Test
    void shouldInvolve_whenSetter() {
        // Arrange
        Category categoryMock = Category.builder().build();
        // Act
        categoryMock.setId(new CategoryId(ID));
        categoryMock.setName(NAME);
        categoryMock.setCreatedAt(CREATED_AT);
        categoryMock.setUpdatedAt(UPDATED_AT);
        // Assert
        assertEquals(ID, categoryMock.getId().getValue());
        assertEquals(NAME, categoryMock.getName());
        assertEquals(CREATED_AT, categoryMock.getCreatedAt());
        assertEquals(UPDATED_AT, categoryMock.getUpdatedAt());
    }

    @Test
    void shouldEqual_whenEquals() {
        // Arrange
        Category category1 = getCategory();
        Category category2 = getCategory();
        // Act
        boolean equal = category1.equals(category2);
        // Assert
        assertTrue(equal);
    }

    @Test
    void shouldNotEqual_whenEquals() {
        // Arrange
        Category category1 = getCategory();
        Category category2 = getCategory();
        category2.setName("name2");
        // Act
        boolean equal = category1.equals(category2);
        // Assert
        assertFalse(equal);
    }

    private Category getCategory() {
        return Category.builder()
                .id(new CategoryId(ID))
                .name(NAME)
                .createdAt(CREATED_AT)
                .updatedAt(UPDATED_AT)
                .build();
    }
}
