package io.github.erickkamii.exception;

import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.RestResponse;


@Provider
public class GlobalExceptionHandler implements ExceptionMapper<Throwable> {

    private static final Logger LOG = Logger.getLogger(GlobalExceptionHandler.class);

    @Context
    UriInfo uriInfo;

    @Override
    @SuppressWarnings("resource")
    public Response toResponse(Throwable ex) {

        int status = RestResponse.Status.INTERNAL_SERVER_ERROR.getStatusCode();
        String message = "Unexpected error";

        if (ex instanceof ApiException apiEx) {
            status = apiEx.getStatus();
            message = apiEx.getMessage();
        } else if (ex instanceof NotFoundException notFoundEx) {
            status = notFoundEx.getStatus();
            message = notFoundEx.getMessage();
        } else if (ex instanceof BusinessException businessEx) {
            status = businessEx.getStatus();
            message = businessEx.getMessage();
        } else if (ex instanceof DomainException domainEx) {
            status = domainEx.getStatus();
            message = domainEx.getMessage();
        } else {
            LOG.error("Unhandled exception", ex);
        }

        var errorResponse = ErrorResponse.of(
                status,
                ex.getClass().getSimpleName(),
                message,
                uriInfo.getPath()
                );

        return RestResponse.status(RestResponse.Status.fromStatusCode(status), errorResponse).toResponse();
    }
}
