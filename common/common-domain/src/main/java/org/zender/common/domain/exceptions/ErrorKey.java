package org.zender.common.domain.exceptions;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorKey {
    PROPERTY("property"),
    VALUE("value"),
    INVALID("invalid");


    private final String domain;
}
