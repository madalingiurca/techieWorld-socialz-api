package tech.madalingiurca.techieworldsocialz.web.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Getter
@NoArgsConstructor
public class AddCommentRequest {
    private UUID postId;
    private String content;
}
