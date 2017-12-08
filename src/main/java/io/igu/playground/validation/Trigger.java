package io.igu.playground.validation;


import java.util.function.Predicate;

public interface Trigger extends Predicate<User> {

    Trigger isBillGatesEmail = user -> "bill.gates@microsoft.com".equalsIgnoreCase(user.getEmail());

    Trigger isUsernameJack = user -> "Jack".equalsIgnoreCase(user.getUsername());
    Trigger isUsernameDeadcore = user -> "Deadcore".equalsIgnoreCase(user.getUsername());

    Trigger isUsernameInUse = isUsernameDeadcore.or(isUsernameJack);

    Trigger isUnderAge = user -> user.getAge() < 18;
    Trigger hasParentsConsent = User::isHasParentsConsent;
    Trigger noConsent = hasParentsConsent.negate();

    default Trigger negate() {
        return user -> !this.test(user);
    }

    default Trigger and(final Trigger other) {
        return user -> this.test(user) && other.test(user);
    }

    default Trigger or(final Trigger other) {
        return user -> this.test(user) || other.test(user);
    }
}
