package org.zender.common.domain.exceptions.common;

import org.zender.common.domain.exceptions.ApplicationException;
import org.zender.common.domain.exceptions.ErrorCode;
import org.zender.common.domain.exceptions.ErrorDetail;

import java.util.Map;
import java.util.Set;

public class DomainResourceExistException extends ApplicationException {
    public DomainResourceExistException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public DomainResourceExistException(ErrorCode errorCode, String message, Set<ErrorDetail> optionData) {
        super(errorCode, message, optionData);
    }
}
