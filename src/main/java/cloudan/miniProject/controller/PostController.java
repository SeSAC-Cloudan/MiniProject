package cloudan.miniProject.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cloudan.miniProject.common.dto.ApiResponseDto;
import cloudan.miniProject.dto.PostRequestDto;
import cloudan.miniProject.dto.PostResponseDto;
import cloudan.miniProject.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController         // 요청이 들어왔을 때 뷰를 반환하는 @Controller와 다르게 요청이 들어왔을 때 데이터를 반환합니다.
@RequiredArgsConstructor
@RequestMapping("/api")     // 이 컨트롤러들의 요청 엔드포인트 중 가장 앞에 공통되는 부분입니다.
public class PostController {
    private final PostService postService;

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<ApiResponseDto> deletePost(@PathVariable int id) {
        ApiResponseDto responseDto = postService.deletePost(id);
        return ResponseEntity.ok().body(responseDto);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<PostResponseDto> getPost(@PathVariable int id) {
        PostResponseDto responseDto = postService.getPost(id);
        return ResponseEntity.ok().body(responseDto);
    }

    @PostMapping("/posts")
    public ResponseEntity<PostResponseDto> createPost(@Valid @RequestBody PostRequestDto requestDto) {
        PostResponseDto responseDto = postService.createPost(requestDto);
        return ResponseEntity.ok().body(responseDto);
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<PostResponseDto> updatePost(
        @PathVariable int id,
        @Valid @RequestBody PostRequestDto requestDto) {
        PostResponseDto responseDto = postService.updatePost(id, requestDto);
        return ResponseEntity.ok().body(responseDto);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<PostResponseDto>> getAllPosts() {
        List<PostResponseDto> responseDtos = postService.getAllPosts();
        return ResponseEntity.ok().body(responseDtos);
    }
}
