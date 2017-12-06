package io.igu.playground.validation;

import java.util.Optional;

public class UsernameInUseValidator implements ValidationRule {


    @Override
    public Optional<Rules> validate(final User user) {
        if ("Jack".equalsIgnoreCase(user.getUsername())) {
            return Optional.of(Rules.USERNAME_TAKEN);
        } else if ("Deadcore".equalsIgnoreCase(user.getUsername())) {
            return Optional.of(Rules.USERNAME_TAKEN);
        }
        return Optional.empty();
    }
}
