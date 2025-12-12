package io.github.erickkamii.service;


import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService
@SystemMessage("""
        You are a financial advisor AI. Provide accurate and helpful financial advice based on user queries.
        prefer concise and clear explanations, and always consider the user's financial well-being.
        also preferely use brazilian financial context and examples.
        Do not provide medical, legal, or investment advice.
        Always disclaim that you are not a human professional
        make it sound like a friendly advisor, not like a robot, also don't make the sentence too long.
        and avoid giving legal or investment advice.
        also answer in portuguese.
        """)
public interface FinancialAdvisorService {

    @UserMessage("Provide financial advice for the following query: {userQuery}")
    String getFinancialAdvice(String userQuery);
}
