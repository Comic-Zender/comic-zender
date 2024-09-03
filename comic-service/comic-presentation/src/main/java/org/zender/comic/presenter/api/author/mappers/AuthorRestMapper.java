package org.zender.comic.presenter.api.author.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.zender.comic.appication.author.commands.CreateAuthorCommand;
import org.zender.comic.appication.author.commands.UpdateAuthorCommand;
import org.zender.comic.domain.author.models.Author;
import org.zender.comic.presenter.api.common.mappers.CommonApiMapper;
import org.zender.comic.shared.http.author.request.CreateAuthorRequest;
import org.zender.comic.shared.http.author.request.UpdateAuthorRequest;
import org.zender.comic.shared.http.author.response.AuthorResponse;
import org.zender.common.mapstruct.CommonMapperConfig;

@Mapper(config = CommonMapperConfig.class, uses = {CommonApiMapper.class})
public interface AuthorRestMapper {
    AuthorRestMapper INSTANCE = Mappers.getMapper(AuthorRestMapper.class);

    CreateAuthorCommand requestToCommand(CreateAuthorRequest request);

    UpdateAuthorCommand requestToCommand(UpdateAuthorRequest request);

    @Mapping(target = "id", source = "id", qualifiedByName = "baseLongIdToLong")
    @Mapping(target = "createdAt", source = "createdAt", qualifiedByName = "instantToLong")
    @Mapping(target = "updatedAt", source = "updatedAt", qualifiedByName = "instantToLong")
    AuthorResponse modelToResponse(Author model);
}
