package io.github.erickkamii.api;

import io.github.erickkamii.dto.request.LoginRequest;
import io.github.erickkamii.dto.request.RegisterRequest;
import io.github.erickkamii.dto.response.LoginResponse;
import io.github.erickkamii.dto.response.RefreshResponse;
import io.github.erickkamii.dto.response.RegisterResponse;
import io.github.erickkamii.service.AuthService;
import jakarta.inject.Inject;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.jboss.resteasy.reactive.RestResponse;

@Path("/api/v1/auth")
public class AuthResource {

    @Inject
    AuthService authService;

    @POST
    @Path("/register")
    public RestResponse<RegisterResponse> register(RegisterRequest request) {
        var response = authService.register(request);
        return RestResponse.ok(response);
    }

    @POST
    @Path("/login")
    public RestResponse<LoginResponse> login(LoginRequest request) {
        var response = authService.login(request);
        return RestResponse.ok(response);
    }

    @POST
    @Path("/refresh")
    public RestResponse<RefreshResponse> refresh(@HeaderParam("Authorization") String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new IllegalArgumentException("Missing or invalid Authorization header");
        }

        var token = authHeader.substring("Bearer ".length());
        var response = authService.refresh(token);

        return RestResponse.ok(response);
    }
}
