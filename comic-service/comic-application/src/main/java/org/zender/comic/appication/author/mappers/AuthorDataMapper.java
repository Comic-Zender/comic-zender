package org.zender.comic.appication.author.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.zender.comic.appication.author.commands.CreateAuthorCommand;
import org.zender.comic.appication.author.commands.UpdateAuthorCommand;
import org.zender.comic.domain.author.models.Author;
import org.zender.common.mapstruct.CommonMapperConfig;

@Mapper(config = CommonMapperConfig.class)
public interface AuthorDataMapper {

    AuthorDataMapper INSTANCE = Mappers.getMapper(AuthorDataMapper.class);

    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Author createCommandToModel(CreateAuthorCommand command);

    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    void updateCommandToModel(@MappingTarget Author author, UpdateAuthorCommand command);
}
