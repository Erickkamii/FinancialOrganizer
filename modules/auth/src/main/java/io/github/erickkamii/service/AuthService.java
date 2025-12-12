package io.github.erickkamii.service;

import io.github.erickkamii.domain.entity.User;
import io.github.erickkamii.dto.request.LoginRequest;
import io.github.erickkamii.dto.response.LoginResponse;
import io.github.erickkamii.dto.request.RegisterRequest;
import io.github.erickkamii.dto.response.RefreshResponse;
import io.github.erickkamii.dto.response.RegisterResponse;
import io.github.erickkamii.exception.ApiException;
import io.github.erickkamii.repository.AuthRepository;
import io.quarkus.elytron.security.common.BcryptUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.UUID;

@ApplicationScoped
public class AuthService {
    @Inject
    TokenService tokenService;
    @Inject
    AuthRepository authRepository;

    @Transactional
    public RegisterResponse register(RegisterRequest request){
        if(authRepository.existsByEmail(request.email())){
            throw new ApiException("Email already in use", 400);
        }
        if(authRepository.existsByUsername(request.username())){
            throw new ApiException("Username already in use", 400);
        }
        String hashedPassword = BcryptUtil.bcryptHash(request.password());
        User user = new User(request.username(), request.email(), hashedPassword);
        authRepository.persist(user);
        return new RegisterResponse(user.getUsername());
    }

    public LoginResponse login (LoginRequest request){
        var userOpt = authRepository.find("email", request.email()).firstResultOptional();
        if(userOpt.isEmpty()){
            throw new ApiException("Invalid email or password", 401);
        }
        var user = userOpt.get();
        if(!BcryptUtil.matches(request.password(), user.getPassword())){
            throw new ApiException("Invalid email or password", 401);
        }
        String accessToken = tokenService.generateAccessToken(user);
        String refreshToken = tokenService.generateRefreshToken(user);
        return new LoginResponse(user.getPublicId(),user.getUsername(), accessToken, refreshToken);
    }

    public RefreshResponse refresh(String refreshToken){
        var claims = tokenService.parseAndValidate(refreshToken);
        String publicIdStr = claims.getSubject();
        UUID publicId = UUID.fromString(publicIdStr);
        var user = authRepository
                .find("publicId", publicId)
                .firstResultOptional()
                .orElseThrow(() -> new ApiException("Invalid refresh token", 401));
        String newAccess = tokenService.generateAccessToken(user);
        String newRefresh = tokenService.generateRefreshToken(user);
        return new RefreshResponse(publicId, newAccess, newRefresh);
    }

}
