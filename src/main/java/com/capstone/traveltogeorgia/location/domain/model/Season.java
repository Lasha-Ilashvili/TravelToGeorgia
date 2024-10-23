package com.capstone.traveltogeorgia.location.domain.model;

public enum Season {
    SUMMER("Summer"),
    WINTER("Winter"),
    WINTER_SUMMER(WINTER + "/" + SUMMER);

    private final String displayName;

    Season(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}