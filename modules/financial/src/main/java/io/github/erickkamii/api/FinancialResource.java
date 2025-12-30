package io.github.erickkamii.api;

import io.github.erickkamii.request.ImportRequest;
import io.github.erickkamii.exception.ApiException;
import io.github.erickkamii.service.ImportService;
import jakarta.inject.Inject;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.RestResponse;

@Path("/api/v1/financial")
public class FinancialResource {

    @Inject
    ImportService service;

    @POST
    @Path("/import")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public RestResponse<?> receiveBankStatement(@BeanParam ImportRequest form) {
        if (form.file() != null) {
            return RestResponse.ok(service.importFile(form));
        } else {
            throw new ApiException("No file uploaded", 400);
        }
    }
}
