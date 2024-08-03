package org.zender.comic.presenter.api.category;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.zender.comic.appication.category.ICategoryService;
import org.zender.comic.appication.category.commands.CreateCategoryCommand;
import org.zender.comic.appication.category.commands.UpdateCategoryCommand;
import org.zender.common.domain.valueobjects.category.CategoryId;
import org.zender.comic.presenter.api.category.mappers.CategoryApiMapper;
import org.zender.comic.shared.http.category.CategoryOperations;
import org.zender.comic.shared.http.category.request.CreateCategoryRequest;
import org.zender.comic.shared.http.category.request.UpdateCategoryRequest;
import org.zender.comic.shared.http.category.response.CategoryResponse;

@RestController
@RequiredArgsConstructor
@Tag(name = "Category Controller")
public class CategoryController implements CategoryOperations {
    private final ICategoryService categoryService;


    @Override
    public CategoryResponse create(CreateCategoryRequest request) {
        CreateCategoryCommand command = CategoryApiMapper.INSTANCE.requestToCommand(request);
        return CategoryApiMapper.INSTANCE.categoryToCategoryResponse(categoryService.save(command));
    }

    @Override
    public CategoryResponse update(Long id, UpdateCategoryRequest request) {
        UpdateCategoryCommand command = CategoryApiMapper.INSTANCE.updateToCommand(request);
        return CategoryApiMapper.INSTANCE.categoryToCategoryResponse(categoryService.update(new CategoryId(id), command));
    }
}
