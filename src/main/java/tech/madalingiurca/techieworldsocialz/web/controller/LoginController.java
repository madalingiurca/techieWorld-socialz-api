package tech.madalingiurca.techieworldsocialz.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tech.madalingiurca.techieworldsocialz.security.UserDetailsImpl;
import tech.madalingiurca.techieworldsocialz.security.jwt.JwtTokenUtil;
import tech.madalingiurca.techieworldsocialz.service.UserService;
import tech.madalingiurca.techieworldsocialz.web.model.request.LoginRequest;
import tech.madalingiurca.techieworldsocialz.web.model.response.LoginResponse;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;

    private final JwtTokenUtil jwtTokenUtil;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {

        final UserDetailsImpl userDetails = userService.login(loginRequest.getUsername(), loginRequest.getPassword());

        return ResponseEntity
                .accepted()
                .contentType(MediaType.APPLICATION_JSON)
                .header("AUTHORIZATION", "Bearer " + jwtTokenUtil.generateToken(userDetails))
                .body(new LoginResponse(userDetails.getAlias(), userDetails.getUsername()));
    }
}
