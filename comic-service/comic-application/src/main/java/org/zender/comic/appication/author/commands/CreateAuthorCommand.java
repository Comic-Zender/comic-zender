package org.zender.comic.appication.author.commands;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record CreateAuthorCommand(
        @NotBlank String name,
        @NotNull LocalDate dateOfBirth
) {
}
