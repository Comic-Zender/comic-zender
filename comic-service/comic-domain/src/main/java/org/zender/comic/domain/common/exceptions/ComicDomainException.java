package org.zender.comic.domain.common.exceptions;

import org.zender.common.domain.exceptions.DomainException;

public class ComicDomainException extends DomainException {

    public ComicDomainException(String message) {
        super(message);
    }

    public ComicDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
