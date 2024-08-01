package org.zender.common.rest.response;


import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
@Builder
public class ErrorResponse {
    private String message;
    private String errorCode;
    private Map<String, Object> details;
}
