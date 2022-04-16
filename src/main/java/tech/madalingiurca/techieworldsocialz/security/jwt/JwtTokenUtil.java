package tech.madalingiurca.techieworldsocialz.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import tech.madalingiurca.techieworldsocialz.security.UserDetailsImpl;

@Component
public class JwtTokenUtil {

    public static final String USERNAME_CLAIM = "username";

    public static final String USER_ALIAS_CLAIM = "alias";

    private final Algorithm jwtAlgorithm;

    public JwtTokenUtil(@Value("${security.jwt.secret}") String jwtSecret) {
        this.jwtAlgorithm = Algorithm.HMAC256(jwtSecret);
    }

    public UserDetailsImpl validateToken(String jwt) {
        return jwtClaimsToUser(JWT.require(jwtAlgorithm).build().verify(jwt));
    }

    private UserDetailsImpl jwtClaimsToUser(DecodedJWT decodedJWT) {
        return UserDetailsImpl.builder()
                .alias(decodedJWT.getClaim(USER_ALIAS_CLAIM).asString())
                .username(decodedJWT.getClaim(USERNAME_CLAIM).asString())
                .build();
    }
}
