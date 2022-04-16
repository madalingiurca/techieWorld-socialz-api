package tech.madalingiurca.techieworldsocialz.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import tech.madalingiurca.techieworldsocialz.security.UserDetailsImpl;
import tech.madalingiurca.techieworldsocialz.security.jwt.JwtTokenUtil;

@Service
@RequiredArgsConstructor
public class UserService {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenUtil jwtTokenUtil;

    public String login(String username, String password) {
        final UserDetailsImpl userDetails = (UserDetailsImpl) authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        username,
                        password
                ))
                .getPrincipal();

        return jwtTokenUtil.generateToken(userDetails);
    }

}
