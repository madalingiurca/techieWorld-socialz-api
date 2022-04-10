package tech.madalingiurca.techieworldsocialz.database.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Accessors(fluent = true)
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String content;

    private ZonedDateTime creationDate;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    public Post(String content) {
        this.creationDate = ZonedDateTime.now();
        this.content = content;
    }

    public Post(String content, List<Comment> comments) {
        this.content = content;
        this.comments = comments;
    }

    public Post addComment(String content) {
        this.comments.add(new Comment(content, this));
        return this;
    }
}
