package org.zender.common.rest.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.zender.common.domain.exceptions.ErrorCode;
import org.zender.common.domain.exceptions.ErrorDetail;
import org.zender.common.domain.exceptions.ErrorKey;
import org.zender.common.domain.exceptions.common.DomainException;
import org.zender.common.domain.exceptions.common.DomainResourceNotFoundException;
import org.zender.common.rest.response.BaseResponse;
import org.zender.common.rest.response.ErrorResponse;

import java.util.HashSet;
import java.util.Set;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DomainException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    BaseResponse<ErrorResponse> handleDomainException(DomainException e) {
        return BaseResponse.error(e);
    }

    @ExceptionHandler(DomainResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    BaseResponse<ErrorResponse> handlerResourceNotFoundException(DomainResourceNotFoundException e) {
        return BaseResponse.error(e);
    }


    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    BaseResponse<ErrorResponse> handlerConstraintViolationException(ConstraintViolationException e) {
        ErrorCode errorCode = ErrorCode.INVALID_PARAMETER;
        Set<ErrorDetail> details = new HashSet<>();
        for (var violation : e.getConstraintViolations()) {
            details.add(
                    ErrorDetail.builder().type(ErrorKey.PROPERTY.getDomain())
                            .value(violation.getPropertyPath().toString())
                            .description(violation.getMessageTemplate())
                            .build()
            );
        }
        DomainException exception = new DomainException(errorCode, e.getMessage(), details);
        return BaseResponse.error(exception);
    }


    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    BaseResponse<ErrorResponse> handleException(RuntimeException e) {
        ErrorCode errorCode = ErrorCode.INTERNAL_SERVER_ERROR;
        DomainException exception = new DomainException(errorCode, e.getMessage());
        return BaseResponse.error(exception);
    }


}
