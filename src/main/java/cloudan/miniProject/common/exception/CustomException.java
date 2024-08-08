package cloudan.miniProject.common.exception;

import lombok.Getter;

/**
 * 서비스 단에서 잘못된 요청을 받았을 때 던질 수 있게끔 커스텀한 예외입니다.
 */
@Getter
public class CustomException extends RuntimeException {
    private final CustomErrorCode errorCode;

    public CustomException(CustomErrorCode errorCode) {
        super(errorCode.getErrorMessage());
        this.errorCode = errorCode;
    }
}
