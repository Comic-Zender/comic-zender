package org.zender.comic.appication.category;

import jakarta.validation.Valid;
import org.zender.comic.appication.category.commands.CreateCategoryCommand;
import org.zender.comic.appication.category.commands.UpdateCategoryCommand;
import org.zender.comic.domain.category.models.Category;
import org.zender.comic.domain.category.valueobjects.CategoryId;

public interface ICategoryService {
    Category save(@Valid CreateCategoryCommand command);

    Category update(CategoryId categoryId, @Valid UpdateCategoryCommand command);
}
