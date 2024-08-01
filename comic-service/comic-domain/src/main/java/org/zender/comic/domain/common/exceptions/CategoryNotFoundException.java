package org.zender.comic.domain.common.exceptions;

import org.zender.common.domain.exceptions.ErrorCode;

import java.util.Map;

public class CategoryNotFoundException extends ComicDomainException {
    public CategoryNotFoundException() {
    }

    public CategoryNotFoundException(Long categoryId) {
        super(Map.of(ErrorCode.CATEGORY_NOT_FOUND.getDomain(), categoryId));
    }
}
