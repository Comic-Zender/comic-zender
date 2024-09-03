package org.zender.comic.domain.author.exceptions;

import org.zender.comic.domain.common.exceptions.ComicDomainException;
import org.zender.common.domain.exceptions.ErrorCode;
import org.zender.common.domain.exceptions.ErrorDetail;
import org.zender.common.domain.exceptions.ErrorKey;
import org.zender.common.domain.valueobjects.author.AuthorId;

import java.util.Set;

public class AuthorNotFoundException extends ComicDomainException {
    public AuthorNotFoundException(String message, AuthorId id) {
        super(ErrorCode.RESOURCE_NOT_FOUND, message, Set.of(ErrorDetail.builder().type(ErrorKey.VALUE.getDomain()).value(id).build()));
    }
}
