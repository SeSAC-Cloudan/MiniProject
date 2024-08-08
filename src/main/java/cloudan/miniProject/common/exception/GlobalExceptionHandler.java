package cloudan.miniProject.common.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import cloudan.miniProject.common.dto.ApiResponseDto;

// Controller 단에서 예외가 터지면 그 예외를 잡아 여기서 처리합니다.
@RestControllerAdvice
public class GlobalExceptionHandler {
    // CustomException이 발생했을 때 이 메서드를 통해 예외의 메시지가 담긴 ApiResponseDto를 클라이언트로 보냅니다.
    @ExceptionHandler({CustomException.class})
    public ResponseEntity<ApiResponseDto> handlerCustomException(CustomException e) {
        return ResponseEntity
            .status(e.getErrorCode().getStatusCode())
            .body(new ApiResponseDto(e.getMessage()));
    }

    // validation 에서 예외가 터졌을 때 관련 에러 메시지를 클라이언트로 보냅니다.
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ApiResponseDto> handlerValicationException(MethodArgumentNotValidException ex) {
        ApiResponseDto apiResponseDto = null;
        for (FieldError fieldError : ex.getFieldErrors()) {
            apiResponseDto = new ApiResponseDto(fieldError.getDefaultMessage());
            break;
        }
        return ResponseEntity.badRequest().body(apiResponseDto);
    }
}
