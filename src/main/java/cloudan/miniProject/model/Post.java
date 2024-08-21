package cloudan.miniProject.model;

import cloudan.miniProject.common.entity.Timestamped;
import cloudan.miniProject.dto.PostRequestDto;
import cloudan.miniProject.dto.PostResponseDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity                 // JPA에서 Entity로 인식하는 어노테이션입니다.
@Getter                 // Entity 의 모든 필드에 대해 Getter를 만들어줍니다.
@Builder                // 일반적인 생성자 대신 객체를 좀 더 직관적으로 생성할 수 있습니다.
@NoArgsConstructor      // 매개변수가 없는 생성자입니다.
@AllArgsConstructor     // 모든 변수가 매개변수로 들어가는 생성자입니다.
public class Post extends Timestamped {
    @Id     // Entity의 PK를 나타냅니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Entity가 만들어질 때 자동으로 ID가 1씩 증가하며 할당됩니다.
    // JPA에서 id를 정의할 때 참조 타입을 사용하게끔 권장합니다.
    // 자동증가방식의 경우 JPA에서 자동으로 id를 할당하는데
    // 아직 ID가 할당되지 않았다는 뜻으로 null값을 이용할 수 도 있기 때문인 것으로 추측됩니다.
    private Integer id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false, length = 50)
    private String author;
    @Column(nullable = false)
    private String content;

    public PostResponseDto toResponseDto() {
        return PostResponseDto.builder()
            .id(id)
            .title(title)
            .author(author)
            .content(content)
            .createdAt(getCreatedAt())
            .build();
    }

    public void update(PostRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.author = requestDto.getAuthor();
        this.content = requestDto.getContent();
    }
}
