package org.zender.comic.appication.category.commands;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateCategoryCommand {
    @NotEmpty(message = "name must not be null")
    private String name;
}
