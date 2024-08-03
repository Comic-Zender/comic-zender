package org.zender.common.domain.exceptions;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorDetail {
    private final String type;
    private final Object value;
    private String description;
}
