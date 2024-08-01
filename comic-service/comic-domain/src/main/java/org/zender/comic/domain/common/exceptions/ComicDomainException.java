package org.zender.comic.domain.common.exceptions;

import org.zender.common.domain.exceptions.ApplicationException;

import java.util.Map;

public class ComicDomainException extends ApplicationException {
    public ComicDomainException() {
    }

    public ComicDomainException(Map<String, Object> optionData) {
        super(optionData);
    }
}
