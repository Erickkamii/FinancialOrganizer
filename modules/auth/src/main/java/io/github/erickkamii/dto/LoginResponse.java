package io.github.erickkamii.dto;

public record LoginResponse(
        String username,
        String authToken,
        String refreshToken
) {
}
