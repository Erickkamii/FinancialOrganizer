package io.github.erickkamii.request;

import io.github.erickkamii.enums.BankType;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.PartType;
import org.jboss.resteasy.reactive.RestForm;
import org.jboss.resteasy.reactive.multipart.FileUpload;

public record ImportRequest(
        @NotNull @RestForm("file")@PartType(MediaType.APPLICATION_OCTET_STREAM) FileUpload file,
        @NotNull @RestForm("bankType") @PartType(MediaType.TEXT_PLAIN) BankType bankType
) {
}
