package org.zender.comic.appication.author;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.zender.comic.appication.author.commands.CreateAuthorCommand;
import org.zender.comic.appication.author.commands.UpdateAuthorCommand;
import org.zender.comic.appication.author.mappers.AuthorDataMapper;
import org.zender.comic.domain.author.exceptions.AuthorNotFoundException;
import org.zender.comic.domain.author.id.generator.AuthorIdGenerator;
import org.zender.comic.domain.author.models.Author;
import org.zender.common.domain.valueobjects.author.AuthorId;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements IAuthorService {

    private final IAuthorRepository authorRepository;
    private final AuthorIdGenerator authorIdGenerator;

    @Override
    public Author findById(AuthorId id) {
        return authorCheck(id);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author create(CreateAuthorCommand command) {
        Author author = AuthorDataMapper.INSTANCE.createCommandToModel(command);
        author.setId(authorIdGenerator.invoke());
        return authorRepository.create(author);
    }

    @Override
    public Author update(AuthorId id, UpdateAuthorCommand command) {
        Author author = authorCheck(id);
        AuthorDataMapper.INSTANCE.updateCommandToModel(author, command);
        return authorRepository.update(author);
    }

    @Override
    public void delete(AuthorId id) {
        Author author = authorCheck(id);
        authorRepository.deleteById(author.getId());
    }

    private Author authorCheck(AuthorId id) {
        return authorRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException("author not found", id));
    }
}
