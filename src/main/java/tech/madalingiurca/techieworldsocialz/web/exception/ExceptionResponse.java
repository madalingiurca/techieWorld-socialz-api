package tech.madalingiurca.techieworldsocialz.web.exception;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Optional;

@Getter
public class ExceptionResponse {

    private final String errorMessage;
    private final String httpStatus;
    private final int httpCode;

    @JsonCreator
    private ExceptionResponse(@JsonProperty("error") String errorMessage,
                              @JsonProperty("http-status") String httpStatus,
                              @JsonProperty("http-code") int httpCode) {
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatus;
        this.httpCode = httpCode;
    }

    public static ExceptionResponse of(BaseException baseException) {
        final HttpStatus httpStatus = Optional.ofNullable(baseException.getClass().getAnnotation(ResponseStatus.class))
                .map(ResponseStatus::value)
                .orElse(HttpStatus.INTERNAL_SERVER_ERROR);

        return new ExceptionResponse(baseException.getMessage(), httpStatus.name(), httpStatus.value());
    }
}
