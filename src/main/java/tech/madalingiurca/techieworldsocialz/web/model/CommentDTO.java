package tech.madalingiurca.techieworldsocialz.web.model;

import lombok.Getter;
import tech.madalingiurca.techieworldsocialz.database.entity.Comment;

@Getter
public class CommentDTO {

    private final Long id;

    private final String author;

    private final String content;

    public CommentDTO(Comment comment) {
        this.id = comment.id();
        this.author = comment.author();
        this.content = comment.content();
    }
}
