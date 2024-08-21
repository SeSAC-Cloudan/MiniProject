package cloudan.miniProject.service;

import cloudan.miniProject.common.dto.ApiResponseDto;
import cloudan.miniProject.dto.PostRequestDto;
import cloudan.miniProject.dto.PostResponseDto;

public interface PostService {
    /**
     * 게시글 ID를 받아 게시글을 삭제합니다.
     * @param id 삭제할 게시글 ID
     * @return 삭제 성공 메시지
     */
    ApiResponseDto deletePost(int id);

    /**
     * 게시글 ID를 받아 해당 ID에 맞는 게시글을 조회합니다.
     * @param id 조회할 게시글 ID
     * @return 게시글 정보
     */
    PostResponseDto getPost(int id);

    /**
     * 게시글 등록 정보를 받아 게시글을 등록합니다.
     * @param requestDto 등록할 게시글 정보
     * @return 등록된 게시글 정보
     */
    PostResponseDto createPost(PostRequestDto requestDto);

    /**
     * 게시글 수정 정보를 받아 게시글을 수정합니다.
     * @param id 수정할 게시글 ID
     * @param requestDto 게시글 수정 정보
     * @return 수정된 게시글 정보
     */
    PostResponseDto updatePost(int id, PostRequestDto requestDto);
}
