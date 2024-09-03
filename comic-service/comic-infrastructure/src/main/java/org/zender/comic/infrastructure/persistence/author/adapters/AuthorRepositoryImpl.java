package org.zender.comic.infrastructure.persistence.author.adapters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.zender.comic.appication.author.IAuthorRepository;
import org.zender.comic.domain.author.models.Author;
import org.zender.comic.infrastructure.persistence.author.mappers.AuthorDataAccessMapper;
import org.zender.comic.infrastructure.persistence.author.repositories.AuthorJpaRepository;
import org.zender.common.domain.valueobjects.author.AuthorId;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AuthorRepositoryImpl implements IAuthorRepository {
    private final AuthorJpaRepository authorJpaRepository;

    @Override
    public List<Author> findAll() {
        return authorJpaRepository.findAll().stream().map(AuthorDataAccessMapper.INSTANCE::entityToModel).toList();
    }

    @Override
    public Optional<Author> findById(AuthorId id) {
        return authorJpaRepository.findById(id.getValue()).map(AuthorDataAccessMapper.INSTANCE::entityToModel);
    }

    @Override
    public Author create(Author model) {
        return AuthorDataAccessMapper.INSTANCE.entityToModel(authorJpaRepository.save(AuthorDataAccessMapper.INSTANCE.modelToEntity(
                model)));
    }

    @Override
    public Author update(Author model) {
        return AuthorDataAccessMapper.INSTANCE.entityToModel(authorJpaRepository.saveAndFlush(AuthorDataAccessMapper.INSTANCE.modelToEntity(
                model)));
    }

    @Override
    public void deleteById(AuthorId id) {
        authorJpaRepository.deleteById(id.getValue());
    }
}
