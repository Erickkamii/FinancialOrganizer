package io.github.erickkamii.api;

import io.github.erickkamii.service.FinancialAdvisorService;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.jboss.resteasy.reactive.RestResponse;

@Path("/api/v1/chat")
public class MessageResource {

    @Inject
    FinancialAdvisorService financialAdvisorService;

    @POST
    public RestResponse<String> sendMessage(String message) {
        String response = financialAdvisorService.getFinancialAdvice(message);
        return RestResponse.ok(response);
    }
}
