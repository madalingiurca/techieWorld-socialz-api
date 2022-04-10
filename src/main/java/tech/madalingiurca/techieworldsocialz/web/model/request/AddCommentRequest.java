package tech.madalingiurca.techieworldsocialz.web.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class AddCommentRequest {
    private Long postId;
    private String content;
}
