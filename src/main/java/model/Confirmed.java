package model;

/**
 *
 */
public enum Confirmed {

    CONFIRMED("Schváleno"),
    NOT_CONFIRMED("Neschváleno");

    // Member to hold the name
    private final String name;

    // constructor to set the string
    private Confirmed(String name) {
        this.name = name;
    }

    public String getName() { //TODO Localization
        return name;
    }
}
