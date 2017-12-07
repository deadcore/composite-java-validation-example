package io.igu.playground.validation;


import java.util.function.Predicate;

public interface Trigger extends Predicate<User> {

    Trigger isBillGatesEmail = user -> "bill.gates@microsoft.com".equalsIgnoreCase(user.getEmail());

    Trigger isUsernameJack = user -> "Jack".equalsIgnoreCase(user.getUsername());
    Trigger isUsernameDeadcore = user -> "Deadcore".equalsIgnoreCase(user.getUsername());

    Trigger isUsernameInUse = isUsernameDeadcore.or(isUsernameJack);

    default Trigger or(final Trigger other) {
        return callAttributes -> this.test(callAttributes) || other.test(callAttributes);
    }
}
