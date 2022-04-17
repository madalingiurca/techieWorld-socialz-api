package tech.madalingiurca.techieworldsocialz.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.madalingiurca.techieworldsocialz.security.UserDetailsImpl;
import tech.madalingiurca.techieworldsocialz.service.CommentManagementService;
import tech.madalingiurca.techieworldsocialz.service.PostManagementService;
import tech.madalingiurca.techieworldsocialz.web.model.PostDTO;
import tech.madalingiurca.techieworldsocialz.web.model.request.AddCommentRequest;
import tech.madalingiurca.techieworldsocialz.web.model.request.CreatePostRequest;
import tech.madalingiurca.techieworldsocialz.web.model.response.GenericOneItemResponse;
import tech.madalingiurca.techieworldsocialz.web.model.response.PostsRetrieveResponse;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostManagementService postManagementService;

    private final CommentManagementService commentManagementService;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<PostsRetrieveResponse> retrievePosts() {

        List<PostDTO> posts = postManagementService.getPosts().stream()
                .map(PostDTO::new)
                .collect(Collectors.toList());

        return ResponseEntity
                .ok()
                .header("Response-Posts-Count", String.valueOf(posts.size()))
                .body(new PostsRetrieveResponse(posts));
    }

    @PostMapping("/new")
    public ResponseEntity<PostDTO> createNewPost(@RequestBody CreatePostRequest createPostRequest,
                                                 @AuthenticationPrincipal UserDetailsImpl userDetails) {
        PostDTO postDTO = new PostDTO(postManagementService.createPost(userDetails.getAlias(), createPostRequest.getContent()));

        return ResponseEntity
                .accepted()
                .body(postDTO);
    }

    @PostMapping("/comment")
    public ResponseEntity<GenericOneItemResponse<Long>> addNewComment(@RequestBody AddCommentRequest request) {
        Long postId = commentManagementService.addComment(request.getPostId(), request.getContent());
        GenericOneItemResponse<Long> response = new GenericOneItemResponse<>("postId", postId);

        return ResponseEntity
                .accepted()
                .body(response);
    }
}
