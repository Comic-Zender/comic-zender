package org.zender.comic.application.category;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.zender.comic.appication.category.CategoryServiceImpl;
import org.zender.comic.appication.category.ICategoryRepository;
import org.zender.comic.appication.category.commands.CreateCategoryCommand;
import org.zender.comic.appication.category.commands.UpdateCategoryCommand;
import org.zender.comic.domain.category.id.generator.CategoryIdGenerator;
import org.zender.comic.domain.category.models.Category;
import org.zender.common.domain.valueobjects.category.CategoryId;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceImplTest {
    private static final Long ID = 1L;
    private static final String NAME = "name";
    private static final Instant CREATED_AT = Instant.now();
    private static final Instant UPDATED_AT = Instant.now();

    @Mock
    private ICategoryRepository categoryRepository;
    @Mock
    private CategoryIdGenerator categoryIdGenerator;
    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Test
    void shouldReturnCategory_whenFindById() {
        // Arrange
        Category categoryMock = getCategory();
        when(categoryRepository.findById(any())).thenReturn(Optional.of(categoryMock));
        // Act
        Category category = categoryService.findById(new CategoryId(ID));
        // Assert
        verify(categoryRepository, times(1)).findById(any());
        assertEquals(categoryMock, category);
    }

    @Test
    void shouldReturnListCategory_whenFindAll() {
        // Arrange
        Category categoryMock = getCategory();
        List<Category> listMock = List.of(categoryMock);
        when(categoryRepository.findAll()).thenReturn(listMock);
        // Act
        List<Category> categories = categoryService.findAll();
        // Assert
        verify(categoryRepository, times(1)).findAll();
        assertEquals(listMock, categories);
    }

    @Test
    void shouldReturnCategory_whenSave() {
        // Arrange
        CreateCategoryCommand commandMock = CreateCategoryCommand.builder().name(NAME).build();
        Category categoryMock = getCategory();
        when(categoryIdGenerator.invoke()).thenReturn(new CategoryId(ID));
        when(categoryRepository.save(any())).thenReturn(categoryMock);
        // Act
        Category category = categoryService.save(commandMock);
        // Assert
        verify(categoryIdGenerator,times(1)).invoke();
        verify(categoryRepository, times(1)).save(any());
        assertEquals(categoryMock, category);
    }

    @Test
    void shouldReturnCategory_whenUpdate() {
        // Arrange
        UpdateCategoryCommand commandMock = UpdateCategoryCommand.builder().name(NAME).build();
        Category categoryMock = getCategory();
        when(categoryRepository.findById(any())).thenReturn(Optional.of(categoryMock));
        when(categoryRepository.update(any())).thenReturn(categoryMock);
        // Act
        Category category = categoryService.update(new CategoryId(ID), commandMock);
        // Assert
        verify(categoryRepository, times(1)).update(any());
        assertEquals(categoryMock, category);
    }

    @Test
    void shouldRemove_whenDelete() {
        // Arrange
        Category categoryMock = getCategory();
        when(categoryRepository.findById(any())).thenReturn(Optional.of(categoryMock));
        // Act
        categoryService.delete(new CategoryId(ID));
        // Assert
        verify(categoryRepository, times(1)).delete(new CategoryId(ID));
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
