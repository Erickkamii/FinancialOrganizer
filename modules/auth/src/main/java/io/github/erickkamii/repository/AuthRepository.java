package io.github.erickkamii.repository;

import io.github.erickkamii.domain.entity.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuthRepository implements PanacheRepository<User> {

    public boolean existsByEmail(String email) {
        return find("email", email).firstResultOptional().isPresent();
    }

    public boolean existsByUsername(String username) {
        return find("username", username).firstResultOptional().isPresent();
    }
}
