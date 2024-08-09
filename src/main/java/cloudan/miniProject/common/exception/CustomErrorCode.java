package cloudan.miniProject.common.exception;

import org.springframework.http.HttpStatus;

import cloudan.miniProject.common.constants.ErrorMsgConstants;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * CustomException을 던질 때 매개변수로 쓰일 Enum입니다.
 */
@Getter
@RequiredArgsConstructor
public enum CustomErrorCode {
    POST_NOT_FOUND(HttpStatus.NOT_FOUND.value(), ErrorMsgConstants.POST_NOT_FOUND);

    private final int statusCode;
    private final String errorMessage;
}
