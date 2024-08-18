package org.zender.comic.appication.category.commands;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateCategoryCommand {
    @NotBlank(message = "name must not be blank")
    @Size(max = 32)
    private String name;
}
