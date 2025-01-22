package io.github.sung01299.howmuch.global.apiPayload.code.status;

import io.github.sung01299.howmuch.global.apiPayload.code.BaseCode;
import io.github.sung01299.howmuch.global.apiPayload.code.ReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessStatus implements BaseCode {

    _OK(HttpStatus.OK, "COMMON200", "Success."),
    _CREATED(HttpStatus.CREATED, "COMMON201", "Created.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ReasonDTO getReason() {
        return ReasonDTO.builder().message(message).code(code).isSuccess(true).build();
    }

    @Override
    public ReasonDTO getReasonHttpStatus() {
        return ReasonDTO.builder().message(message).code(code).isSuccess(true).httpStatus(httpStatus).build();
    }


}
