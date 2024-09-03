package org.zender.comic.shared.http.author.request;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record CreateAuthorRequest(
        String name,
        LocalDate dateOfBirth
) {
}
