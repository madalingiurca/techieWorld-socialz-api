package tech.madalingiurca.techieworldsocialz.web.exception;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class BaseException extends RuntimeException {

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    @JsonCreator
    public BaseException(@JsonProperty("error-message") String message) {
        super(message);
    }


}