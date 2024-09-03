package org.zender.comic.shared.http.category.response;

import lombok.Builder;

@Builder
public record CategoryResponse(
        String id,
        String name,
        Long createdAt,
        Long updatedAt
) {

}
