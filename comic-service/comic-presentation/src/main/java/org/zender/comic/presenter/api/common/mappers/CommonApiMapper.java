package org.zender.comic.presenter.api.common.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.zender.common.domain.valueobjects.BaseId;
import org.zender.common.mapstruct.CommonMapperConfig;

import java.time.Instant;
import java.util.Objects;

@Mapper(config = CommonMapperConfig.class)
public interface CommonApiMapper {
    @Named("baseLongIdToLong")
    default Long baseLongIdToLong(BaseId<Long> id) {
        if (Objects.isNull(id)) {
            return null;
        }
        return id.getValue();
    }

    @Named("instantToLong")
    default Long instantToLong(Instant instant) {
        if (Objects.isNull(instant)) {
            return null;
        }
        return instant.toEpochMilli();
    }
}
