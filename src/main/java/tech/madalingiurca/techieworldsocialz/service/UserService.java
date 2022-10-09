package tech.madalingiurca.techieworldsocialz.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import tech.madalingiurca.techieworldsocialz.database.entity.User;
import tech.madalingiurca.techieworldsocialz.database.repository.UserRepository;
import tech.madalingiurca.techieworldsocialz.security.UserDetailsImpl;
import tech.madalingiurca.techieworldsocialz.security.UserNotFoundException;

@Service
@RequiredArgsConstructor
public class UserService {

    private final AuthenticationManager authenticationManager;

    private final UserRepository userRepository;

    public UserDetailsImpl login(String username, String password) {
        return (UserDetailsImpl) authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        username,
                        password
                ))
                .getPrincipal();
    }

    public UserDetailsImpl retrieveUserDetails(String username) {
        final User user = userRepository
                .findUserByUsername(username)
                .orElseThrow(UserNotFoundException::new);

        return UserDetailsImpl.builder()
                .alias(user.getAlias())
                .username(user.getUsername())
                .build();
    }

}
