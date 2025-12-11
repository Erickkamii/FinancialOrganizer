package io.github.erickkamii.api;

import io.github.erickkamii.domain.User;
import io.github.erickkamii.dto.LoginResponse;
import io.github.erickkamii.service.TokenService;
import io.smallrye.jwt.build.Jwt;
import jakarta.inject.Inject;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.RestResponse;
import org.jose4j.jwt.JwtClaims;

import java.util.Map;

@Path("/api/v1/auth")
public class AuthResource {

    @Inject
    TokenService tokenService;

    @POST
    @Path("/refresh")
    public RestResponse<LoginResponse> refresh(@HeaderParam("Authorization") String refreshToken) {
        String token = refreshToken.replace("Bearer ", "");

        JwtClaims claims = Jwt.verify(token);

        Long uid = claims.getClaimValue("uid", Long.class);
        String email = claims.getSubject();
        var user = new User(uid, email);
        String newAccess = tokenService.generateAccessToken(user);

        return Response.ok(Map.of("access_token", newAccess)).build();
    }
}
