package org.zender.comic.appication.category;

import jakarta.validation.Valid;
import org.zender.comic.appication.category.commands.CreateCategoryCommand;
import org.zender.comic.appication.category.commands.UpdateCategoryCommand;
import org.zender.comic.domain.category.models.Category;
import org.zender.common.domain.valueobjects.category.CategoryId;

import java.util.List;

public interface ICategoryService {
    Category save(@Valid CreateCategoryCommand command);

    Category update(CategoryId categoryId, @Valid UpdateCategoryCommand command);

    Category findById(CategoryId categoryId);

    List<Category> findAll();

    void delete(CategoryId categoryId);
}
