package org.zender.common.domain.exceptions;

import lombok.Getter;

import java.util.Set;

@Getter
public abstract class ApplicationException extends RuntimeException {
    private final Set<ErrorDetail> optionData;
    private final ErrorCode errorCode;

    public ApplicationException(ErrorCode errorCode, String message) {
        this(errorCode, message, null);
    }

    public ApplicationException(ErrorCode errorCode, String message, Set<ErrorDetail> optionData) {
        super(message);
        this.errorCode = errorCode;
        this.optionData = optionData;
    }
}
