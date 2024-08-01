package org.zender.common.domain.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    // Standard
    RESOURCE_NOT_FOUND("resource_not_found"),
    RESOURCE_ALREADY_EXIST("resource_already_exist"),
    INVALID_PARAMETER("invalid_parameter"),
    INTERNAL_SERVER_ERROR("internal_server_error"),
    UNAUTHORIZED("unauthorized"),
    FORBIDDEN("forbidden"),
    BAD_REQUEST("bad_request"),

    // Detail
    CATEGORY_NOT_FOUND("category_not_found"),
    ;

    private final String domain;
}
