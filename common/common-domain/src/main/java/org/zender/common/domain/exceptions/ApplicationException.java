package org.zender.common.domain.exceptions;

import lombok.Getter;

import java.util.Map;

@Getter
public abstract class ApplicationException extends RuntimeException {
    private Map<String,Object> optionData;

    public ApplicationException() {
        super();
    }

    public ApplicationException(Map<String,Object> optionData) {
        this.optionData = optionData;
    }
}
