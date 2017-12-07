package io.igu.playground.validation;

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

        final UserValidation validation = UserValidation.empty.
                and(UserValidation.emailTaken).
                and(UserValidation.usernameTaken);

        System.out.println(validation.apply(user)); // [EMAIL_INUSE, USERNAME_TAKEN]
    }

}