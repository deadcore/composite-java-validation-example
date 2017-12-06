package io.igu.playground.validation;

import java.util.*;

public class Application {

    public static void main(String... args) {

        final User user = new User(
                "Bill",
                "Gates",
                13,
                "bill.gates@microsoft.com",
                "deadcore",
                false
        );

        final List<ValidationRule> rules = Arrays.asList(
                new EmailInUseValidator(),
                new UsernameInUseValidator()
        );

        final Set<Rules> brokenRules = rules.stream().reduce(new HashSet<>(), (x, y) -> {
            final HashSet<Rules> mutation = new HashSet<>(x);
            final Optional<Rules> maybeBrokenRule = y.validate(user);
            maybeBrokenRule.ifPresent(mutation::add);
            return mutation;
        }, (x, y) -> {
            final HashSet<Rules> mutation = new HashSet<>(x);
            mutation.addAll(y);
            return mutation;
        });

        System.out.println(brokenRules);

    }

}