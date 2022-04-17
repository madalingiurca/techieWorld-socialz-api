package tech.madalingiurca.techieworldsocialz.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import tech.madalingiurca.techieworldsocialz.web.exception.BaseException;
import tech.madalingiurca.techieworldsocialz.web.exception.ExceptionResponse;

import java.util.Objects;

@Slf4j
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({BaseException.class})
    public ResponseEntity<ExceptionResponse> handleExceptions(BaseException ex) {
        log.error("Exception thrown: {}", ex.getLocalizedMessage(), ex);
        final ExceptionResponse exceptionResponse = ExceptionResponse.of(ex);

        return ResponseEntity
                .status(
                        Objects.requireNonNull(HttpStatus.resolve(exceptionResponse.getHttpCode()))
                )
                .body(exceptionResponse);
    }
}
