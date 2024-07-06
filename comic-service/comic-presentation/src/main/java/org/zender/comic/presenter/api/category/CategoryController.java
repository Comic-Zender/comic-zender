package org.zender.comic.presenter.api.category;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.zender.comic.appication.category.ICategoryService;
import org.zender.comic.appication.category.commands.CreateCategoryCommand;
import org.zender.comic.presenter.api.category.mappers.CategoryApiMapper;
import org.zender.comic.shared.http.category.CategoryApi;
import org.zender.comic.shared.http.category.request.CreateCategoryRequest;
import org.zender.comic.shared.http.category.response.CategoryResponse;

@RestController
@RequiredArgsConstructor
public class CategoryController implements CategoryApi {
    private final ICategoryService categoryService;


    @Override
    public CategoryResponse create(CreateCategoryRequest request) {
        CreateCategoryCommand command = CategoryApiMapper.INSTANCE.requestToCommand(request);
        return CategoryApiMapper.INSTANCE.categoryToCategoryResponse(categoryService.save(command));
    }
}
