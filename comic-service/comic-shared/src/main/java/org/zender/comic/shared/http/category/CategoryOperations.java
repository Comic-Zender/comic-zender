package org.zender.comic.shared.http.category;

import org.springframework.web.bind.annotation.*;
import org.zender.comic.shared.http.category.request.CreateCategoryRequest;
import org.zender.comic.shared.http.category.request.UpdateCategoryRequest;
import org.zender.comic.shared.http.category.response.CategoryResponse;

public interface CategoryOperations {
    @PostMapping("api/comic/categories")
    CategoryResponse create(@RequestBody CreateCategoryRequest request);

    @PutMapping("api/comic/categories/{id}")
    CategoryResponse update(@PathVariable Long id, @RequestBody UpdateCategoryRequest request);
}
