package org.zender.common.domain.valueobjects;

import lombok.Getter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Getter
public abstract class BaseId<Type> {

    private final Type value;

    public BaseId(Type value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof BaseId<?> baseId)) return false;

        return new EqualsBuilder().append(value, baseId.value).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(value).toHashCode();
    }
}
