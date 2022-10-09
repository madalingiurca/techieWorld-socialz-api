package tech.madalingiurca.techieworldsocialz.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PostNotFoundException extends BaseException {
    public PostNotFoundException() {
        super("The post you are looking for doesn't exist");
    }
}
