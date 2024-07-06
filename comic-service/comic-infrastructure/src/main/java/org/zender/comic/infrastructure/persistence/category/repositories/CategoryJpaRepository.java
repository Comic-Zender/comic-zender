package org.zender.comic.infrastructure.persistence.category.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zender.comic.infrastructure.persistence.category.entities.CategoryEntity;

public interface CategoryJpaRepository extends JpaRepository<CategoryEntity, Long> {
}
