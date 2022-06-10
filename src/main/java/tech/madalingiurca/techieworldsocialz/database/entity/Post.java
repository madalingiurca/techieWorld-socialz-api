package tech.madalingiurca.techieworldsocialz.database.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Accessors(fluent = true)
@Table(name = "posts")
public class Post {

    @Id
    @Type(type = "org.hibernate.type.UUIDCharType")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String author;

    @Column(columnDefinition = "TEXT")
    private String content;

    private ZonedDateTime creationDate;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private final List<Comment> comments = new ArrayList<>();

    public Post(String author, String content) {
        this.creationDate = ZonedDateTime.now();
        this.author = author;
        this.content = content;
    }

    public Post addComment(String author, String content) {
        this.comments.add(new Comment(author, content, this));
        return this;
    }
}
