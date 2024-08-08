package cloudan.miniProject.service;

import org.springframework.stereotype.Service;

import cloudan.miniProject.repository.PostRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor        // 필요한 매개변수(final)로만 이루어진 생성자입니다.
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
}
