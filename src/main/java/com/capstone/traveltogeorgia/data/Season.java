package com.capstone.traveltogeorgia.data;

public enum Season {
    SUMMER("Summer"),
    WINTER("Winter"),
    WINTER_SUMMER(WINTER.displayName + "/" + WINTER.displayName);

    private final String displayName;

    Season(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}