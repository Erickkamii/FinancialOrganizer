package io.github.erickkamii.dto;

import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.PartType;
import org.jboss.resteasy.reactive.RestForm;
import org.jboss.resteasy.reactive.multipart.FileUpload;

public record ImportRequest(
        @RestForm("file")@PartType(MediaType.APPLICATION_OCTET_STREAM) FileUpload file,
        @RestForm("accessToken")@PartType(MediaType.TEXT_PLAIN) String accessToken
        ) {
}
