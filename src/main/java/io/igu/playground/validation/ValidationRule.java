package io.igu.playground.validation;

import java.util.Optional;

public interface ValidationRule {
    Optional<Rules> validate(User user);
}
