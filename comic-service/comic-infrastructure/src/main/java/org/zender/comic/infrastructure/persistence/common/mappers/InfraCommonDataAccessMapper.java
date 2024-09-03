package org.zender.comic.infrastructure.persistence.common.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.zender.common.domain.valueobjects.BaseId;
import org.zender.common.domain.valueobjects.author.AuthorId;
import org.zender.common.domain.valueobjects.category.CategoryId;
import org.zender.common.mapstruct.CommonMapperConfig;

import java.util.Objects;

@Mapper(config = CommonMapperConfig.class)
public interface InfraCommonDataAccessMapper {
    @Named("baseLongIdToLong")
    default Long baseLongIdToLong(BaseId<Long> id) {
        if (Objects.isNull(id)) {
            return null;
        }
        return id.getValue();
    }

    @Named("longToCategoryId")
    default CategoryId longToCategoryId(Long id) {
        if (Objects.isNull(id)) {
            return null;
        }
        return new CategoryId(id);
    }

    @Named("longToAuthorId")
    default AuthorId longToAuthorId(Long id) {
        if (Objects.isNull(id)) {
            return null;
        }
        return new AuthorId(id);
    }
}
