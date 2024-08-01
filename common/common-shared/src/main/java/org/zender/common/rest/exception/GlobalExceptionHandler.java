package org.zender.common.rest.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.zender.common.domain.exceptions.ApplicationException;
import org.zender.common.domain.exceptions.ErrorCode;
import org.zender.common.domain.exceptions.ErrorCodeValue;
import org.zender.common.rest.response.BaseResponse;
import org.zender.common.rest.response.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    BaseResponse<ErrorResponse> handleDomainException(ApplicationException e) {
        ErrorCode value = ErrorCode.BAD_REQUEST;
        if (e.getClass().isAnnotationPresent(ErrorCodeValue.class)) {
            value = e.getClass().getAnnotation(ErrorCodeValue.class).value();
        }
        return BaseResponse.error(value, e);
    }
}
