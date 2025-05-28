package org.example;

public enum Genre {
    FICTION,
    NON_FICTION,
    SCIENCE,
    HISTORY,
    BIOGRAPHY,
    FANTASY,
    OTHER;

    public static Genre safeValueOf(String name) {
        try {
            return name == null ? OTHER : Genre.valueOf(name.toUpperCase());
        } catch (IllegalArgumentException e) {
            return OTHER;
        }
    }
}
