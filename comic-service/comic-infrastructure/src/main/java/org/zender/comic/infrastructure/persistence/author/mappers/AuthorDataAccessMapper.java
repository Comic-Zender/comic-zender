package org.zender.comic.infrastructure.persistence.author.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.zender.comic.domain.author.models.Author;
import org.zender.comic.infrastructure.persistence.author.entities.AuthorEntity;
import org.zender.comic.infrastructure.persistence.common.mappers.InfraCommonDataAccessMapper;
import org.zender.common.mapstruct.CommonMapperConfig;

@Mapper(config = CommonMapperConfig.class, uses = {InfraCommonDataAccessMapper.class})
public interface AuthorDataAccessMapper {
    AuthorDataAccessMapper INSTANCE = Mappers.getMapper(AuthorDataAccessMapper.class);

    @Mapping(target = "id", source = "id", qualifiedByName = "longToAuthorId")
    Author entityToModel(AuthorEntity entity);

    @Mapping(target = "id", source = "id", qualifiedByName = "baseLongIdToLong")
    @Mapping(target = "deletedAt", ignore = true)
    AuthorEntity modelToEntity(Author model);
}
