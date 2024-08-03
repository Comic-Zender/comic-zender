package org.zender.comic.presenter.api.category.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.zender.comic.appication.category.commands.CreateCategoryCommand;
import org.zender.comic.appication.category.commands.UpdateCategoryCommand;
import org.zender.comic.domain.category.models.Category;
import org.zender.comic.presenter.api.common.mappers.CommonApiMapper;
import org.zender.comic.shared.http.category.request.CreateCategoryRequest;
import org.zender.comic.shared.http.category.request.UpdateCategoryRequest;
import org.zender.comic.shared.http.category.response.CategoryResponse;
import org.zender.common.mapstruct.CommonMapperConfig;

@Mapper(config = CommonMapperConfig.class, uses = {CommonApiMapper.class})
public interface CategoryApiMapper {
    CategoryApiMapper INSTANCE = Mappers.getMapper(CategoryApiMapper.class);

    CreateCategoryCommand requestToCommand(CreateCategoryRequest request);

    UpdateCategoryCommand updateToCommand(UpdateCategoryRequest request);

    @Mapping(target = "id", source = "model.id", qualifiedByName = "baseLongIdToLong")
    @Mapping(target = "createdAt", source = "model.createdAt", qualifiedByName = "instantToLong")
    @Mapping(target = "updatedAt", source = "model.updatedAt", qualifiedByName = "instantToLong")
    CategoryResponse categoryToCategoryResponse(Category model);
}
