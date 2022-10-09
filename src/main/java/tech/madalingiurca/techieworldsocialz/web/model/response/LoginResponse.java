package tech.madalingiurca.techieworldsocialz.web.model.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class LoginResponse {
    private final String alias;
    private final String username;

    @JsonCreator
    public LoginResponse(@JsonProperty("alias") String alias,
                         @JsonProperty("username") String username) {
        this.alias = alias;
        this.username = username;
    }


}
