package org.zender.comic.domain.common.exceptions;

import org.zender.common.domain.exceptions.ErrorCode;
import org.zender.common.domain.exceptions.ErrorDetail;
import org.zender.common.domain.exceptions.ErrorKey;

import java.util.Set;

public class CategoryNotFoundException extends ComicDomainException {
    public CategoryNotFoundException(String message, Long categoryId) {
        super(ErrorCode.RESOURCE_NOT_FOUND, message, Set.of(ErrorDetail.builder().type(ErrorKey.VALUE.getDomain()).value(categoryId).build()));
    }
}
