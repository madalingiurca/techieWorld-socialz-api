package tech.madalingiurca.techieworldsocialz.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tech.madalingiurca.techieworldsocialz.service.UserService;
import tech.madalingiurca.techieworldsocialz.web.model.request.LoginRequest;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody LoginRequest loginRequest) {

        final String authToken = userService.login(loginRequest.getUsername(), loginRequest.getPassword());

        return ResponseEntity
                .accepted()
                .header("AUTHORIZATION", "Bearer " + authToken)
                .build();
    }
}
