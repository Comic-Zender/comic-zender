package org.zender.comic.shared.http.author.response;

import lombok.Builder;

@Builder
public record AuthorResponse(
        String id,
        String name,
        String dateOfBirth,
        Long createdAt,
        Long updatedAt
) {
}
