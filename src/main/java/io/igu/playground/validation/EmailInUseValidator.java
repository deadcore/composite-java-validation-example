package io.igu.playground.validation;

import java.util.Optional;

public class EmailInUseValidator implements ValidationRule {


    @Override
    public Optional<Rules> validate(final User user) {
        if ("bill.gates@microsoft.com".equalsIgnoreCase(user.getEmail())) {
            return Optional.of(Rules.EMAIL_INUSE);
        }
        return Optional.empty();
    }
}
