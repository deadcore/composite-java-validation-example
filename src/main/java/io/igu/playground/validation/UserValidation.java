package io.igu.playground.validation;

import java.util.function.Function;
import java.util.function.Predicate;

import static io.igu.playground.validation.ValidationResult.invalid;
import static io.igu.playground.validation.ValidationResult.valid;


public interface UserValidation extends Function<User, ValidationResult> {
    UserValidation empty = $ -> valid();

    UserValidation usernameTaken = rule(Trigger.isUsernameInUse, Rules.USERNAME_TAKEN);

    UserValidation emailTaken = rule(Trigger.isBillGatesEmail, Rules.EMAIL_INUSE);

    static UserValidation rule(final Predicate<User> predicate, final Rules rule) {
        return user -> predicate.test(user) ? invalid(rule) : valid();
    }

    default UserValidation and(final UserValidation other) {
        return user ->
        {
            final ValidationResult left = this.apply(user);
            final ValidationResult right = other.apply(user);

            return left.merge(right);
        };
    }
}