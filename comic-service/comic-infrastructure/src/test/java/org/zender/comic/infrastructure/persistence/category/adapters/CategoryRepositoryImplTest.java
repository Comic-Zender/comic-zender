package org.zender.comic.infrastructure.persistence.category.adapters;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.zender.comic.domain.category.models.Category;
import org.zender.comic.infrastructure.persistence.category.entities.CategoryEntity;
import org.zender.comic.infrastructure.persistence.category.repositories.CategoryJpaRepository;
import org.zender.common.domain.valueobjects.category.CategoryId;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CategoryRepositoryImplTest {
    private static final Long ID = 1L;
    private static final String NAME = "name";
    private static final Instant CREATED_AT = Instant.now();
    private static final Instant UPDATED_AT = Instant.now();
    @Mock
    private CategoryJpaRepository categoryJpaRepository;
    @InjectMocks
    private CategoryRepositoryImpl categoryRepository;

    @Test
    void shouldReturnCategory_whenSave() {
        // Arrange
        Category categoryMock = getModel();
        CategoryEntity entityMock = getEntity();
        when(categoryJpaRepository.save(any())).thenReturn(entityMock);
        // Act
        Category category = categoryRepository.save(categoryMock);
        // Assert
        ArgumentCaptor<CategoryEntity> captor = ArgumentCaptor.forClass(CategoryEntity.class);
        verify(categoryJpaRepository, times(1)).save(captor.capture());
        CategoryEntity entityValue = captor.getValue();
        assertEquals(categoryMock.getId().getValue(), entityValue.getId());
        assertEquals(categoryMock.getName(), entityValue.getName());
        assertEquals(categoryMock.getCreatedAt(), entityValue.getCreatedAt());
        assertEquals(categoryMock.getUpdatedAt(), entityValue.getUpdatedAt());

        assertEquals(entityMock.getId(), category.getId().getValue());
        assertEquals(entityMock.getName(), category.getName());
        assertEquals(entityMock.getCreatedAt(), category.getCreatedAt());
        assertEquals(entityMock.getUpdatedAt(), category.getUpdatedAt());
    }

    @Test
    void shouldReturnCategory_whenUpdate() {
        // Arrange
        Category categoryMock = getModel();
        CategoryEntity entityMock = getEntity();
        when(categoryJpaRepository.saveAndFlush(any())).thenReturn(entityMock);
        // Act
        Category category = categoryRepository.update(categoryMock);
        // Assert
        ArgumentCaptor<CategoryEntity> captor = ArgumentCaptor.forClass(CategoryEntity.class);
        verify(categoryJpaRepository, times(1)).saveAndFlush(captor.capture());
        CategoryEntity entityValue = captor.getValue();
        assertEquals(categoryMock.getId().getValue(), entityValue.getId());
        assertEquals(categoryMock.getName(), entityValue.getName());
        assertEquals(categoryMock.getCreatedAt(), entityValue.getCreatedAt());
        assertEquals(categoryMock.getUpdatedAt(), entityValue.getUpdatedAt());

        assertEquals(entityMock.getId(), category.getId().getValue());
        assertEquals(entityMock.getName(), category.getName());
        assertEquals(entityMock.getCreatedAt(), category.getCreatedAt());
        assertEquals(entityMock.getUpdatedAt(), category.getUpdatedAt());
    }

    @Test
    void shouldReturnCategory_whenFindById() {
        // Arrange
        CategoryEntity entityMock = getEntity();
        when(categoryJpaRepository.findById(any())).thenReturn(Optional.of(entityMock));
        // Act
        Optional<Category> categoryOptional = categoryRepository.findById(new CategoryId(ID));
        // Assert
        verify(categoryJpaRepository, times(1)).findById(any());
        assertTrue(categoryOptional.isPresent());
        Category category = categoryOptional.get();

        assertEquals(entityMock.getId(), category.getId().getValue());
        assertEquals(entityMock.getName(), category.getName());
        assertEquals(entityMock.getCreatedAt(), category.getCreatedAt());
        assertEquals(entityMock.getUpdatedAt(), category.getUpdatedAt());
    }

    @Test
    void shouldReturnList_whenFindAll() {
        // Arrange
        CategoryEntity entityMock = getEntity();
        List<CategoryEntity> entityListMock = List.of(entityMock);
        when(categoryJpaRepository.findAll()).thenReturn(entityListMock);
        // Act
        List<Category> categories = categoryRepository.findAll();
        // Assert
        verify(categoryJpaRepository, times(1)).findAll();
        assertFalse(categories.isEmpty());
        Category category = categories.get(0);

        assertEquals(entityMock.getId(), category.getId().getValue());
        assertEquals(entityMock.getName(), category.getName());
        assertEquals(entityMock.getCreatedAt(), category.getCreatedAt());
        assertEquals(entityMock.getUpdatedAt(), category.getUpdatedAt());
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
