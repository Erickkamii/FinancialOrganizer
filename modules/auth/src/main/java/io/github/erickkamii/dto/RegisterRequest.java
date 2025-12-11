package io.github.erickkamii.dto;

public record RegisterRequest(
        String email,
        String username,
        String password
) {
}
