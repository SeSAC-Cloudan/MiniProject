package cloudan.miniProject.common.dto;

import lombok.Getter;

/**
 * Api 요청 시 클라이언트로 메시지만 반환할 때 쓰이는 DTO입니다.
 */
@Getter
public class ApiResponseDto {
    private String message;

    /**
     * @param message 반환할 메시지
     */
    public ApiResponseDto(String message) {
        this.message = message;
    }
}
