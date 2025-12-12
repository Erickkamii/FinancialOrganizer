package io.github.erickkamii.dto.response;

import java.util.UUID;

public record LoginResponse(
        UUID publicId,
        String username,
        String authToken,
        String refreshToken
) {
}
