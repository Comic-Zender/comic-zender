package org.zender.comic.shared.http.author.request;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record UpdateAuthorRequest(
        String name,
        LocalDate dateOfBirth
) {
}
