package io.github.erickkamii.dto.request;

public record LoginRequest(
        String email,
        String password
) {
}
