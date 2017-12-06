package io.igu.playground.validation;

public class User {

    private final String firstname;
    private final String lastname;
    private final int age;
    private final String email;
    private final String username;
    private final boolean hasParentsConsent;

    public User(final String firstname, final String lastname, final int age, final String email, final String username, final boolean hasParentsConsent) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.email = email;
        this.username = username;
        this.hasParentsConsent = hasParentsConsent;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public boolean isHasParentsConsent() {
        return hasParentsConsent;
    }
}
