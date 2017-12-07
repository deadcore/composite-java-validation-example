package io.igu.playground.validation;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.Collections.emptySet;

public interface UserValidation extends Function<User, Set<Rules>> {
    UserValidation empty = $ -> emptySet();

    UserValidation usernameTaken = rule(Trigger.isUsernameInUse, Rules.USERNAME_TAKEN);

    UserValidation emailTaken = rule(Trigger.isBillGatesEmail, Rules.EMAIL_INUSE);

    static UserValidation rule(final Predicate<User> predicate, final Rules rule) {
        return user -> predicate.test(user) ? Collections.singleton(rule) : emptySet();
    }

    default UserValidation and(final UserValidation other) {
        return user ->
        {
            final Set<Rules> left = this.apply(user);
            final Set<Rules> right = other.apply(user);

            final Set<Rules> merged = new HashSet<>(left);
            merged.addAll(right);

            return merged;
        };
    }
}