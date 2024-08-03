package org.zender.common.domain.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    // Standard
    INTERNAL_SERVER_ERROR("internal_server_error"),
    RESOURCE_NOT_FOUND("resource_not_found"),
    RESOURCE_ALREADY_EXIST("resource_already_exist"),
    INVALID_PARAMETER("invalid_parameter"),
    ;

    private final String domain;
}
