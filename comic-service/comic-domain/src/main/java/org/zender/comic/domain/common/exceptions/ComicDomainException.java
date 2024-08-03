package org.zender.comic.domain.common.exceptions;

import org.zender.common.domain.exceptions.ApplicationException;
import org.zender.common.domain.exceptions.ErrorCode;
import org.zender.common.domain.exceptions.ErrorDetail;
import org.zender.common.domain.exceptions.common.DomainResourceNotFoundException;

import java.util.Map;
import java.util.Set;

public class ComicDomainException extends DomainResourceNotFoundException {
    public ComicDomainException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public ComicDomainException(ErrorCode errorCode, String message, Set<ErrorDetail> optionData) {
        super(errorCode, message, optionData);
    }
}
