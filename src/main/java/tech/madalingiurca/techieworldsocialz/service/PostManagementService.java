package tech.madalingiurca.techieworldsocialz.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.madalingiurca.techieworldsocialz.database.entity.Post;
import tech.madalingiurca.techieworldsocialz.database.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostManagementService {

    private final PostRepository postRepository;

    public List<Post> getPosts() {
        return new ArrayList<>(postRepository.findAll());
    }

    public Post createPost(String content) {
        return postRepository.save(new Post(content));
    }
}
