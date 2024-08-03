package org.zender.comic.infrastructure.persistence.category.adapters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.zender.comic.appication.category.ICategoryRepository;
import org.zender.comic.domain.category.models.Category;
import org.zender.common.domain.valueobjects.category.CategoryId;
import org.zender.comic.infrastructure.persistence.category.entities.CategoryEntity;
import org.zender.comic.infrastructure.persistence.category.mappers.CategoryDataAccessMapper;
import org.zender.comic.infrastructure.persistence.category.repositories.CategoryJpaRepository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CategoryRepositoryImpl implements ICategoryRepository {
    private final CategoryJpaRepository categoryJpaRepository;

    @Override
    public Category save(Category model) {
        CategoryEntity entity = CategoryDataAccessMapper.INSTANCE.categoryToCategoryEntity(model);
        return CategoryDataAccessMapper.INSTANCE.categoryEntityToCategory(categoryJpaRepository.save(entity));
    }

    @Override
    public Category update(Category model) {
        CategoryEntity entity = CategoryDataAccessMapper.INSTANCE.categoryToCategoryEntity(model);
        return CategoryDataAccessMapper.INSTANCE.categoryEntityToCategory(categoryJpaRepository.saveAndFlush(entity));
    }

    @Override
    public Optional<Category> findById(CategoryId id) {
        return categoryJpaRepository.findById(id.getValue()).map(CategoryDataAccessMapper.INSTANCE::categoryEntityToCategory);
    }

    @Override
    public List<Category> findAll() {
        return categoryJpaRepository.findAll().stream().map(CategoryDataAccessMapper.INSTANCE::categoryEntityToCategory).toList();
    }
}
