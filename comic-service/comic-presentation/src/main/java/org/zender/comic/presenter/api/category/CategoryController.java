package org.zender.comic.presenter.api.category;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.zender.comic.appication.category.ICategoryService;
import org.zender.comic.appication.category.commands.CreateCategoryCommand;
import org.zender.comic.appication.category.commands.UpdateCategoryCommand;
import org.zender.comic.domain.category.models.Category;
import org.zender.comic.presenter.api.category.mappers.CategoryApiMapper;
import org.zender.comic.shared.http.category.CategoryOperations;
import org.zender.comic.shared.http.category.request.CreateCategoryRequest;
import org.zender.comic.shared.http.category.request.UpdateCategoryRequest;
import org.zender.comic.shared.http.category.response.CategoryResponse;
import org.zender.common.domain.valueobjects.category.CategoryId;
import org.zender.common.rest.response.BaseResponse;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryController implements CategoryOperations {
    private final ICategoryService categoryService;


    @Override
    public BaseResponse<CategoryResponse> create(CreateCategoryRequest request) {
        CreateCategoryCommand command = CategoryApiMapper.INSTANCE.requestToCommand(request);
        return BaseResponse.success(CategoryApiMapper.INSTANCE.categoryToCategoryResponse(categoryService.save(command)));
    }

    @Override
    public BaseResponse<CategoryResponse> update(Long id, UpdateCategoryRequest request) {
        UpdateCategoryCommand command = CategoryApiMapper.INSTANCE.updateToCommand(request);
        return BaseResponse.success(CategoryApiMapper.INSTANCE.categoryToCategoryResponse(categoryService.update(new CategoryId(id), command)));
    }

    @Override
    public BaseResponse<List<CategoryResponse>> findAll() {
        List<Category> categories = categoryService.findAll();
        return BaseResponse.success(categories.stream().map(CategoryApiMapper.INSTANCE::categoryToCategoryResponse).toList());
    }

    @Override
    public BaseResponse<CategoryResponse> findById(Long id) {
        Category category = categoryService.findById(new CategoryId(id));
        return BaseResponse.success(CategoryApiMapper.INSTANCE.categoryToCategoryResponse(category));
    }

    @Override
    public BaseResponse<Void> delete(Long id) {
        categoryService.delete(new CategoryId(id));
        return BaseResponse.success(null);
    }
}
