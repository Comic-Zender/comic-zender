package org.zender.comic.shared.http.category;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.zender.comic.shared.http.category.request.CreateCategoryRequest;
import org.zender.comic.shared.http.category.request.UpdateCategoryRequest;
import org.zender.comic.shared.http.category.response.CategoryResponse;
import org.zender.common.rest.response.BaseResponse;

import java.util.List;

public interface CategoryOperations {
    @PostMapping("api/comic/categories")
    @ResponseStatus(HttpStatus.CREATED)
    BaseResponse<CategoryResponse> create(@RequestBody CreateCategoryRequest request);

    @PutMapping("api/comic/categories/{id}")
    BaseResponse<CategoryResponse> update(@PathVariable Long id, @RequestBody UpdateCategoryRequest request);

    @GetMapping("api/comic/categories")
    BaseResponse<List<CategoryResponse>> findAll();

    @GetMapping("api/comic/categories/{id}")
    BaseResponse<CategoryResponse> findById(@PathVariable Long id);

    @DeleteMapping("api/comic/categories/{id}")
    BaseResponse<Void> delete(@PathVariable Long id);
}
