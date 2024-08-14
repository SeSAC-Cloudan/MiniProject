package cloudan.miniProject.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cloudan.miniProject.common.constants.PostConstants;
import cloudan.miniProject.common.dto.ApiResponseDto;
import cloudan.miniProject.common.exception.CustomErrorCode;
import cloudan.miniProject.common.exception.CustomException;
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

    private Post findPost(int id) {
        return postRepository.findById(id).orElseThrow(
            () -> new CustomException(CustomErrorCode.POST_NOT_FOUND)
        );
    }
}
