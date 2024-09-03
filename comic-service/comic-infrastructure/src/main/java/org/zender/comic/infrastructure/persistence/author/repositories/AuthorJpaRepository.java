package org.zender.comic.infrastructure.persistence.author.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zender.comic.infrastructure.persistence.author.entities.AuthorEntity;

public interface AuthorJpaRepository extends JpaRepository<AuthorEntity, Long> {
}
