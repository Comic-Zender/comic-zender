package org.zender.commondomain.id.generator;

import org.zender.commondomain.valueobjects.BaseId;

public interface IGeneratorId<ID extends BaseId<?>> {
    BaseId<?> invoke();
}
