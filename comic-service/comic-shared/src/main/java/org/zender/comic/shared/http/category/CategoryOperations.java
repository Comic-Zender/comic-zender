package org.zender.comic.shared.http.category;

import org.springframework.web.bind.annotation.*;
import org.zender.comic.shared.http.category.request.CreateCategoryRequest;
import org.zender.comic.shared.http.category.request.UpdateCategoryRequest;
import org.zender.comic.shared.http.category.response.CategoryResponse;

@RequestMapping("api/comic/categories")
public interface CategoryOperations {
    @PostMapping
    CategoryResponse create(@RequestBody CreateCategoryRequest request);

    @PutMapping("{id}")
    CategoryResponse update(@PathVariable Long id, @RequestBody UpdateCategoryRequest request);
}
