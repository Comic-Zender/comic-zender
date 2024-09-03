package org.zender.comic.appication.author;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.zender.comic.appication.author.commands.CreateAuthorCommand;
import org.zender.comic.appication.author.commands.UpdateAuthorCommand;
import org.zender.comic.domain.author.models.Author;
import org.zender.common.domain.valueobjects.author.AuthorId;

import java.util.List;

public interface IAuthorService {
    Author findById(@NotNull AuthorId id);

    List<Author> findAll();

    Author create(@Valid CreateAuthorCommand command);

    Author update(@NotNull AuthorId id, @Valid UpdateAuthorCommand command);

    void delete(@NotNull AuthorId id);
}
