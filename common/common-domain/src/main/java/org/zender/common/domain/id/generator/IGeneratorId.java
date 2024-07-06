package org.zender.common.domain.id.generator;

import org.zender.common.domain.valueobjects.BaseId;

public interface IGeneratorId<ID extends BaseId<?>> {
    ID invoke();
}
