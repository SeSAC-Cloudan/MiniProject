package cloudan.miniProject.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostResponseDto {
    private int id;
    private String title;
    private String author;
    private String content;
    private LocalDateTime createdAt;
}
