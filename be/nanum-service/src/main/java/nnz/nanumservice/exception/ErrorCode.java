package nnz.nanumservice.exception;


import io.github.eello.nnz.common.exception.AbstractErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@RequiredArgsConstructor
public enum ErrorCode implements AbstractErrorCode {

    USER_NOT_FOUND("U009", "등록되지 않은 사용자입니다.", NOT_FOUND),
    SHOW_NOT_FOUND("S001", "등록되지 않은 공연입니다.", NOT_FOUND),
    CATEGORY_NOT_FOUND("C001", "등록되지 않은 카테고리입니다.", NOT_FOUND),
    NANUM_NOT_FOUND("N001", "등록되지 않은 나눔입니다.", NOT_FOUND),
    NANUM_NOT_ACTIVE("N003", "진행중인 나눔이 아닙니다.", BAD_REQUEST),
    NANUM_CLOSE("N004", "마감된 나눔입니다.", NOT_FOUND),
    USER_NANUM_NOT_FOUND("UN002", "등록되지 않은 받은 나눔입니다.", NOT_FOUND),
    ALREADY_USER_NANUM("UN003", "이미 처리한 나눔 인증입니다.", CONFLICT),
    USER_NANUM_NOT_CERTIFIED("UN004", "인증되지 않은 나눔 신청입니다.", NOT_FOUND),
    ALREADY_RECEIVED_USER_NANUM("UN005", "이미 수령한 나눔입니다.", NOT_FOUND),
    USER_NANUM_NEED_CERTIFICATION("UN006", "인증이 필요한 나눔입니다.", BAD_REQUEST),
    DUPLICATED_USER_NANUM("UN006", "이미 신청한 나눔입니다.", BAD_REQUEST),
    TAG_NOT_FOUND("T001", "등록되지 않은 태그입니다.", NOT_FOUND),
    USER_INFORMATION_INCONSISTENCY("U016", "해당 글쓴이와 정보가 불일치합니다.", BAD_REQUEST),

    PUSH_NOTI_FAIL("P001", "푸시 알림 전송에 실패했습니다.", INTERNAL_SERVER_ERROR),
    ;

    private final String code;
    private final String message;
    private final HttpStatus status;

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public HttpStatus getStatus() {
        return this.status;
    }

}
