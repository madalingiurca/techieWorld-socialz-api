package tech.madalingiurca.techieworldsocialz.web.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import tech.madalingiurca.techieworldsocialz.database.models.Post;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostDTO {

    private final Long id;

    private final String content;

    private final ZonedDateTime creationDate;

    private final List<CommentDTO> comments;

    public PostDTO(Post postEntity) {
        this.id = postEntity.id();
        this.content = postEntity.content();
        this.creationDate = postEntity.creationDate();
        this.comments = postEntity.comments().stream()
                .map(CommentDTO::new)
                .collect(Collectors.toList());
    }
}
