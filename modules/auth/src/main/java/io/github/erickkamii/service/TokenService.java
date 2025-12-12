package io.github.erickkamii.service;

import io.github.erickkamii.domain.entity.User;
import io.smallrye.jwt.auth.principal.JWTParser;
import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.jwt.JsonWebToken;

import java.util.UUID;

@ApplicationScoped
public class TokenService {

    @Inject
    JWTParser jwtParser;

    private static final int ACCESS_EXP = 900;
    private static final int REFRESH_EXP = 604800;

    public String generateAccessToken(User user) {
        long now = System.currentTimeMillis() / 1000;

        return Jwt.issuer("financial-auth")
                .subject(user.getPublicId().toString())
                .claim("email", user.getEmail())
                .claim("username", user.getUsername())
                .issuedAt(now)
                .expiresAt(now + ACCESS_EXP)
                .sign();
    }

    public String generateRefreshToken(User user) {
        long now = System.currentTimeMillis() / 1000;

        return Jwt.issuer("financial-auth")
                .subject(user.getPublicId().toString())
                .claim("type", "refresh")
                .issuedAt(now)
                .expiresAt(now + REFRESH_EXP)
                .sign();
    }

    public UUID extractPublicId(String token) {
        try {
            var jwt = jwtParser.parse(token);
            return UUID.fromString(jwt.getSubject());
        } catch (Exception e) {
            throw new RuntimeException("Invalid token");
        }
    }

    public JsonWebToken parseAndValidate(String token){
        try {
            var jwt = jwtParser.parse(token);
            if (!"refresh".equals(jwt.getClaim("type"))) {
                throw new RuntimeException("Invalid token type");
            }
            return jwt;
        } catch (Exception e) {
            throw new RuntimeException("Invalid token");
        }
    }
}
