package cloudan.miniProject.dto;

import org.hibernate.validator.constraints.Length;

import cloudan.miniProject.common.constants.PostConstants;
import cloudan.miniProject.model.Post;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PostRequestDto {
    private String title;
    @Length(max = 50, message = PostConstants.AUTHOR_LENGTH_EXCEEDED)
    private String author;
    private String content;

    public Post toEntity() {
        return Post.builder()
            .title(title)
            .author(author)
            .content(content)
            .build();
    }
}
