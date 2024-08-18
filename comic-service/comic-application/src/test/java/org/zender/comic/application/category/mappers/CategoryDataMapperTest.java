package org.zender.comic.application.category.mappers;

import org.junit.jupiter.api.Test;
import org.zender.comic.appication.category.commands.CreateCategoryCommand;
import org.zender.comic.appication.category.commands.UpdateCategoryCommand;
import org.zender.comic.appication.category.mappers.CategoryDataMapper;
import org.zender.comic.domain.category.models.Category;
import org.zender.common.domain.valueobjects.category.CategoryId;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoryDataMapperTest {
    private static final Long ID = 1L;
    private static final String NAME = "name";
    private static final Instant CREATED_AT = Instant.now();
    private static final Instant UPDATED_AT = Instant.now();

    @Test
    void shouldReturnCategory_whenMapFromCommand() {
        // Arrange
        CreateCategoryCommand commandMock = CreateCategoryCommand.builder()
                .name(NAME)
                .build();
        // Act
        Category category = CategoryDataMapper.INSTANCE.createCategoryCommandToCategory(commandMock);
        // Assert
        assertEquals(NAME, category.getName());
    }

    @Test
    void shouldReturnNewCategory_whenMapFromUpdate() {
        // Arrange
        String newName = "newName";
        UpdateCategoryCommand commandMock = UpdateCategoryCommand.builder()
                .name(newName)
                .build();
        Category categoryMock = getCategory();
        // Act
        CategoryDataMapper.INSTANCE.updateCategoryCommandToCategory(categoryMock, commandMock);
        // Assert
        assertEquals(newName, categoryMock.getName());
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
