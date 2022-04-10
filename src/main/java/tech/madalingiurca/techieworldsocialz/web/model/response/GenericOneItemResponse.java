package tech.madalingiurca.techieworldsocialz.web.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GenericOneItemResponse<V> {

    @JsonIgnore
    private final String fieldName;

    private final V field;

    public GenericOneItemResponse(String fieldName, V value) {
        this.fieldName = fieldName;
        this.field = value;
    }
}
