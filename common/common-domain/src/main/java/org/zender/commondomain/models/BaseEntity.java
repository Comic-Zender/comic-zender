package org.zender.commondomain.models;

import lombok.Getter;
import lombok.Setter;
import org.zender.commondomain.valueobjects.BaseId;

@Getter
@Setter
public abstract class BaseEntity<ID extends BaseId<?>> {
    private ID id;
}
