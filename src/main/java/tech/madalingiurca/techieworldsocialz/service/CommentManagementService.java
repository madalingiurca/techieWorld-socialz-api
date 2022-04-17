package tech.madalingiurca.techieworldsocialz.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.madalingiurca.techieworldsocialz.database.entity.Post;
import tech.madalingiurca.techieworldsocialz.database.repository.PostRepository;
import tech.madalingiurca.techieworldsocialz.web.exception.PostNotFoundException;

@RequiredArgsConstructor
@Service
public class CommentManagementService {

    private final PostRepository postRepository;

    public Long addComment(Long postId, String author, String content) {
        Post post = postRepository
                .findById(postId)
                .orElseThrow(PostNotFoundException::new);
        return postRepository.save(post.addComment(author, content)).id();
    }
}
