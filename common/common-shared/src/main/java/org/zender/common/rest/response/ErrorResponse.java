package org.zender.common.rest.response;


import lombok.Builder;
import lombok.Getter;
import org.zender.common.domain.exceptions.ErrorDetail;

import java.util.Set;

@Getter
@Builder
public class ErrorResponse {
    private String message;
    private String errorCode;
    private Set<ErrorDetail> details;


}
