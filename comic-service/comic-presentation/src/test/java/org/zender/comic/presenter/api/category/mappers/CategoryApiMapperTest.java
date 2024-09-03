package org.zender.comic.presenter.api.category.mappers;

import org.junit.jupiter.api.Test;
import org.zender.comic.appication.category.commands.CreateCategoryCommand;
import org.zender.comic.appication.category.commands.UpdateCategoryCommand;
import org.zender.comic.domain.category.models.Category;
import org.zender.comic.shared.http.category.request.CreateCategoryRequest;
import org.zender.comic.shared.http.category.request.UpdateCategoryRequest;
import org.zender.comic.shared.http.category.response.CategoryResponse;
import org.zender.common.domain.valueobjects.category.CategoryId;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoryApiMapperTest {
    private static final Long ID = 1L;
    private static final String NAME = "name";
    private static final Instant CREATED_AT = Instant.now();
    private static final Instant UPDATED_AT = Instant.now();

    @Test
    void shouldReturnCommand_whenMapFromCreateCategoryRequest() {
        // Arrange
        CreateCategoryRequest requestMock = new CreateCategoryRequest(NAME);
        // Act
        CreateCategoryCommand command = CategoryApiMapper.INSTANCE.createToCommand(requestMock);
        // Assert
        assertEquals(requestMock.name(), command.getName());
    }

    @Test
    void shouldReturnCommand_whenMapFromUpdateCategoryRequest() {
        // Arrange
        UpdateCategoryRequest requestMock = new UpdateCategoryRequest(NAME);
        // Act
        UpdateCategoryCommand command = CategoryApiMapper.INSTANCE.updateToCommand(requestMock);
        // Assert
        assertEquals(requestMock.name(), command.getName());
    }

    @Test
    void shouldReturnResponse_whenMapFromCategory() {
        // Arrange
        Category categoryMock = Category.builder()
                .id(new CategoryId(ID))
                .name(NAME)
                .createdAt(CREATED_AT)
                .updatedAt(UPDATED_AT)
                .build();
        // Act
        CategoryResponse response = CategoryApiMapper.INSTANCE.categoryToCategoryResponse(categoryMock);
        // Assert
        assertEquals(categoryMock.getId().getValue().toString(), response.id());
        assertEquals(categoryMock.getName(), response.name());
        assertEquals(categoryMock.getCreatedAt().toEpochMilli(), response.createdAt());
        assertEquals(categoryMock.getUpdatedAt().toEpochMilli(), response.updatedAt());
    }
}
