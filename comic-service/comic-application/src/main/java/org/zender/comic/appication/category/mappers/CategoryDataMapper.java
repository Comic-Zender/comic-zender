package org.zender.comic.appication.category.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;
import org.zender.comic.appication.category.commands.CreateCategoryCommand;
import org.zender.comic.appication.category.commands.UpdateCategoryCommand;
import org.zender.comic.domain.category.models.Category;
import org.zender.common.mapstruct.CommonMapperConfig;

@Mapper(config = CommonMapperConfig.class)
public interface CategoryDataMapper {
    CategoryDataMapper INSTANCE = Mappers.getMapper(CategoryDataMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Category createCategoryCommandToCategory(CreateCategoryCommand command);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "command.name", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateCategoryCommandToCategory(@MappingTarget Category category, UpdateCategoryCommand command);
}
