package org.zender.comic.infrastructure.persistence.category.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.zender.comic.domain.category.models.Category;
import org.zender.comic.infrastructure.persistence.category.entities.CategoryEntity;
import org.zender.common.mapstruct.CommonMapperConfig;

@Mapper(config = CommonMapperConfig.class, uses = {InfraCommonDataAccessMapper.class})
public interface CategoryDataAccessMapper {
    CategoryDataAccessMapper INSTANCE = Mappers.getMapper(CategoryDataAccessMapper.class);

    @Mapping(target = "id", source = "model.id", qualifiedByName = "baseLongIdToLong")
    @Mapping(target = "deletedAt", ignore = true)
    CategoryEntity categoryToCategoryEntity(Category model);

    @Mapping(target = "id", source = "entity.id", qualifiedByName = "longToCategoryId")
    Category categoryEntityToCategory(CategoryEntity entity);
}
