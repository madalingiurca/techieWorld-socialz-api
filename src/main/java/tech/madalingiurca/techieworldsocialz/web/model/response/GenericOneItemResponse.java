package tech.madalingiurca.techieworldsocialz.web.model.response;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.util.Collections;
import java.util.Map;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GenericOneItemResponse<V> {

    @JsonIgnore
    private final String fieldName;

    @JsonIgnore
    private final V field;

    public GenericOneItemResponse(String fieldName, V value) {
        this.fieldName = fieldName;
        this.field = value;
    }

    @JsonAnyGetter
    public Map<String, V> setFieldName() {
        return Collections.singletonMap(fieldName, field);
    }
}
