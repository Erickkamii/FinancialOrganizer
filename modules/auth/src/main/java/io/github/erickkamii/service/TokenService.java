package io.github.erickkamii.service;

import io.github.erickkamii.domain.User;
import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TokenService {

    public String generateAccessToken(User user){
        long now = System.currentTimeMillis()/1000;
        long exp = now + 900;

        return Jwt.issuer("financial-auth")
                .upn(user.getEmail())
                .claim("uid", user.getId())
                .expiresAt(exp)
                .sign();
    }

    public String generateRefreshToken(User user){
        long now = System.currentTimeMillis()/1000;
        long exp = now + 900;

        return Jwt.issuer("erick-auth")
                .upn(user.getEmail())
                .claim("uid", user.getId())
                .expiresAt(exp)
                .sign();
    }
}
