package io.github.erickkamii.api;

import io.github.erickkamii.dto.ImportRequest;
import io.github.erickkamii.exception.ApiException;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.RestResponse;

@Path("/api/v1/financial")
public class FinancialResource {

    @POST
    @Path("/import")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public RestResponse<?> receiveBankStatement(@BeanParam ImportRequest form) {
        if (form.file() != null) {
            // Process the uploaded file
            String fileName = form.file().fileName();
            long fileSize = form.file().size();
            // Here you would add your file processing logic
            return RestResponse.ok("Received file: " + fileName + " of size: " + fileSize + " bytes");
        } else {
            throw new ApiException("No file uploaded", 400);
        }
    }
}
