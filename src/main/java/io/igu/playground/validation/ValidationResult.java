package io.igu.playground.validation;

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;
import static java.util.Collections.emptySet;

public interface ValidationResult {

    ValidationResult merge(final ValidationResult right);

    boolean isValid();

    static ValidationResult valid() {
        return Results.valid();
    }

    static ValidationResult invalid(final Set<Rules> reasons) {
        return new Invalid(reasons);
    }

    static ValidationResult invalid(final Rules... reasons) {
        return new Invalid(new HashSet<>(asList(reasons)));
    }

    default Set<Rules> getReasons() {
        return emptySet();
    }

    class Invalid implements ValidationResult {

        private final Set<Rules> reasons;

        Invalid(final Set<Rules> reasons) {
            this.reasons = reasons;
        }

        @Override
        public Set<Rules> getReasons() {
            return this.reasons;
        }

        @Override
        public ValidationResult merge(final ValidationResult right) {
            final HashSet<Rules> mutation = new HashSet<>(reasons);
            mutation.addAll(right.getReasons());
            return ValidationResult.invalid(mutation);
        }

        @Override
        public boolean isValid() {
            return false;
        }

    }

    class Valid implements ValidationResult {
        @Override
        public ValidationResult merge(final ValidationResult right) {
            return right;
        }

        @Override
        public boolean isValid() {
            return true;
        }
    }

    class Results {
        private static final ValidationResult VALID = new Valid();

        static ValidationResult valid() {
            return VALID;
        }
    }
}