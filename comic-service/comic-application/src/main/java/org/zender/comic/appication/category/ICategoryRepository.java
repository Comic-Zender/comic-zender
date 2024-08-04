package org.zender.comic.appication.category;

import org.zender.comic.domain.category.models.Category;
import org.zender.common.domain.valueobjects.category.CategoryId;

import java.util.List;
import java.util.Optional;

public interface ICategoryRepository {
    Category save(Category model);

    Category update(Category model);

    Optional<Category> findById(CategoryId id);

    List<Category> findAll();

    void delete(CategoryId id);
}
