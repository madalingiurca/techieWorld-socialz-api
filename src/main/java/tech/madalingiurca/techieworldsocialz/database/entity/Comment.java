package tech.madalingiurca.techieworldsocialz.database.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Getter()
@Accessors(fluent = true)
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String author;

    private String content;

    @ManyToOne
    private Post post;

    public Comment(String author, String content, Post post) {
        this.author = author;
        this.content = content;
        this.post = post;
    }
}
