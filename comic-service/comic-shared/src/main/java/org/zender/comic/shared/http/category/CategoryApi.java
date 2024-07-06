package org.zender.comic.shared.http.category;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zender.comic.shared.http.category.request.CreateCategoryRequest;
import org.zender.comic.shared.http.category.response.CategoryResponse;

@RequestMapping("api/comic/categories")
public interface CategoryApi {
    @PostMapping
    CategoryResponse create(@RequestBody CreateCategoryRequest request);
}
