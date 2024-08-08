package cloudan.miniProject.service;

import cloudan.miniProject.common.dto.ApiResponseDto;

public interface PostService {
    /**
     * 게시글 ID를 받아 게시글을 삭제합니다.
     * @param id 삭제할 게시글 ID
     * @return 삭제 성공 메시지
     */
    ApiResponseDto deletePost(int id);
}
