package io.igu.playground.validation;

import static io.igu.playground.validation.UserValidation.emailTaken;
import static io.igu.playground.validation.UserValidation.underage;
import static io.igu.playground.validation.UserValidation.usernameTaken;

public class Application {

    public static void main(String... args) {

        final User user = new User(
                "Bill",
                "Gates",
                13,
                "bill.gates@microsoft.com",
                "deadcore",
                true
        );

        final UserValidation validation = UserValidation.empty.
                and(emailTaken).
                and(usernameTaken).
                and(underage);

        System.out.println(validation.apply(user).getReasons()); // [EMAIL_INUSE, USERNAME_TAKEN]
    }

}