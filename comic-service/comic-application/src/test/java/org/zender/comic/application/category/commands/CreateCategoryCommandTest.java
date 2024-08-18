package org.zender.comic.application.category.commands;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zender.comic.appication.category.commands.CreateCategoryCommand;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateCategoryCommandTest {
    private Validator validator;
    private static final String NAME = "name";

    @BeforeEach
    public void setup() {
        try (ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
            validator = factory.getValidator();
        }
    }

    @Test
    void shouldValidate_whenValid() {
        // Arrange
        CreateCategoryCommand commandMock = CreateCategoryCommand.builder()
                .name(NAME)
                .build();
        // Act
        var violations = validator.validate(commandMock);
        // Assert
        assertTrue(violations.isEmpty());
    }

    @Test
    void shouldNotValidate_whenValid() {
        // Arrange
        int sizeExpect = 1;
        CreateCategoryCommand commandMock = CreateCategoryCommand.builder()
                .build();
        // Act
        var violations = validator.validate(commandMock);
        // Assert
        assertEquals(sizeExpect, violations.size());
    }


}
