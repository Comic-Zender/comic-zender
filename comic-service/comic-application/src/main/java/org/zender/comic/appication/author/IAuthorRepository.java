package org.zender.comic.appication.author;

import org.zender.comic.domain.author.models.Author;
import org.zender.common.domain.valueobjects.author.AuthorId;

import java.util.List;
import java.util.Optional;

public interface IAuthorRepository {
    List<Author> findAll();

    Optional<Author> findById(AuthorId id);

    Author create(Author model);

    Author update(Author model);

    void deleteById(AuthorId id);
}
