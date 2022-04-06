package tech.madalingiurca.techieworldsocialz.web.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import tech.madalingiurca.techieworldsocialz.database.models.Post;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class PostsRetrieveResponse {

    @JsonProperty(value = "posts", required = true)
    List<Post> posts;
}
