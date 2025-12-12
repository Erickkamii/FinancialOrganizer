package io.github.erickkamii.dto.request;

public record RegisterRequest(
        String email,
        String username,
        String password
) {
}
