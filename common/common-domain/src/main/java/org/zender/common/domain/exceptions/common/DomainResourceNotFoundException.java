package org.zender.common.domain.exceptions.common;

import org.zender.common.domain.exceptions.ApplicationException;
import org.zender.common.domain.exceptions.ErrorCode;
import org.zender.common.domain.exceptions.ErrorCodeValue;

import java.util.Map;

@ErrorCodeValue(ErrorCode.RESOURCE_NOT_FOUND)
public class DomainResourceNotFoundException extends ApplicationException {
    public DomainResourceNotFoundException() {
    }

    public DomainResourceNotFoundException(Map<String, Object> optionData) {
        super(optionData);
    }
}
