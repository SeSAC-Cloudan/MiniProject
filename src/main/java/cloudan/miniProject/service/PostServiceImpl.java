package cloudan.miniProject.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cloudan.miniProject.common.constants.PostConstants;
import cloudan.miniProject.common.dto.ApiResponseDto;
import cloudan.miniProject.common.exception.CustomErrorCode;
import cloudan.miniProject.common.exception.CustomException;
import cloudan.miniProject.dto.PostRequestDto;
import cloudan.miniProject.dto.PostResponseDto;
import cloudan.miniProject.model.Post;
import cloudan.miniProject.repository.PostRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor        // 필요한 매개변수(final)로만 이루어진 생성자입니다.
@Transactional                  // 트랜잭션
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Override
    public ApiResponseDto deletePost(int id) {
        findPost(id);
        postRepository.deleteById(id);
        return new ApiResponseDto(PostConstants.DELETE_SUCCESS);
    }

    @Override
    @Transactional(readOnly = true)
    public PostResponseDto getPost(int id) {
        Post post = findPost(id);
        return post.toResponseDto();
    }

    @Override
    public PostResponseDto createPost(PostRequestDto requestDto) {
        Post post = requestDto.toEntity();
        Post savedPost = postRepository.save(post);
        return savedPost.toResponseDto();
    }

    @Override
    public PostResponseDto updatePost(int id, PostRequestDto requestDto) {
        Post post = findPost(id);
        post.update(requestDto);
        return post.toResponseDto();
    }

    @Override
    public List<PostResponseDto> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(Post::toResponseDto).toList();
    }

    private Post findPost(int id) {
        return postRepository.findById(id).orElseThrow(
            () -> new CustomException(CustomErrorCode.POST_NOT_FOUND)
        );
    }
}
