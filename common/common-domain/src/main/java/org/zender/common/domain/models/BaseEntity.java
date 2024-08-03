package org.zender.common.domain.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.zender.common.domain.valueobjects.BaseId;

@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode
public abstract class BaseEntity<ID extends BaseId<?>> {
    private ID id;
}
