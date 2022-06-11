package tech.madalingiurca.techieworldsocialz.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.madalingiurca.techieworldsocialz.database.entity.Post;
import tech.madalingiurca.techieworldsocialz.database.repository.PostRepository;
import tech.madalingiurca.techieworldsocialz.web.exception.PostNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostManagementService {

    private final PostRepository postRepository;

    public List<Post> getPosts() {
        return new ArrayList<>(postRepository.findAll());
    }

    public Post findById(long id) {
        return postRepository.findById(id)
                .orElseThrow(PostNotFoundException::new);
    }

    public Post createPost(String author, String content) {
        return postRepository.save(new Post(author, content));
    }

    public void delete(long id) {
        Post post = findById(id);
        postRepository.delete(post);
    }
}
