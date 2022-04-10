package tech.madalingiurca.techieworldsocialz.web.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import tech.madalingiurca.techieworldsocialz.web.model.PostDTO;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class PostsRetrieveResponse {

    @JsonProperty(value = "posts", required = true)
    List<PostDTO> posts;
}
