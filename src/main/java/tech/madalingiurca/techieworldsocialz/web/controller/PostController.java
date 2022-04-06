package tech.madalingiurca.techieworldsocialz.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.madalingiurca.techieworldsocialz.database.models.Post;
import tech.madalingiurca.techieworldsocialz.service.PostManagementService;
import tech.madalingiurca.techieworldsocialz.web.model.request.CreatePostRequest;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostManagementService postManagementService;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Post>> retrievePosts() {
        return ResponseEntity.ok(postManagementService.getPosts());
    }

    @PostMapping("/new")
    public ResponseEntity<Post> createNewPost(@RequestBody CreatePostRequest createPostRequest) {
        return ResponseEntity.accepted().body(postManagementService.createPost(createPostRequest.getContent()));
    }
}
