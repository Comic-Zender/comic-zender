package org.zender.common.rest.response;

import lombok.Builder;
import lombok.Getter;
import org.zender.common.domain.exceptions.ApplicationException;

@Getter
@Builder
public class BaseResponse<T> {
    private T data;
    @Builder.Default
    private boolean success = true;

    public static <T> BaseResponse<T> success(T data) {
        return BaseResponse.<T>builder()
                .data(data)
                .success(true)
                .build();
    }

    public static BaseResponse<ErrorResponse> error(ApplicationException exception) {
        return BaseResponse.<ErrorResponse>builder()
                .data(ErrorResponse.builder()
                        .errorCode(exception.getErrorCode().getDomain())
                        .message(exception.getMessage())
                        .details(exception.getOptionData())
                        .build())
                .success(false)
                .build();
    }
}
