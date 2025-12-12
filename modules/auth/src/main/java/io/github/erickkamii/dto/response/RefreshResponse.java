package io.github.erickkamii.dto.response;

import java.util.UUID;

public record RefreshResponse(
        UUID publicId,
        String authToken,
        String refreshToken
) {
}
