package model;

/**
 *
 */
public enum UserRole {

    GUEST("Host"),
    ADMIN("Admin");

    // Member to hold the name
    private final String name;

    // constructor to set the string
    private UserRole(String name) {
        this.name = name;
    }

    public String getName() { //TODO Localization
        return name;
    }
}
