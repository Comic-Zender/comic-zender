package org.zender.comic.shared.http.category.response;

public record CategoryResponse(
        String id,
        String name,
        Long createdAt,
        Long updatedAt
) {

}
