package org.zender.common.domain.exceptions.common;

import org.zender.common.domain.exceptions.ApplicationException;
import org.zender.common.domain.exceptions.ErrorCode;
import org.zender.common.domain.exceptions.ErrorCodeValue;

import java.util.Map;

@ErrorCodeValue(ErrorCode.BAD_REQUEST)
public class DomainException extends ApplicationException {
    public DomainException() {
    }

    public DomainException(Map<String, Object> optionData) {
        super(optionData);
    }
}
