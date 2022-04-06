package tech.madalingiurca.techieworldsocialz.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Accessors(fluent = true)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String content;

    @OneToMany(mappedBy = "post", cascade = {CascadeType.REMOVE}, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    public Post(String content) {
        this.content = content;
    }

    public Post(String content, List<Comment> comments) {
        this.content = content;
        this.comments = comments;
    }

    public Post addComment(Comment comment) {
        this.comments.add(comment);
        return this;
    }
}
