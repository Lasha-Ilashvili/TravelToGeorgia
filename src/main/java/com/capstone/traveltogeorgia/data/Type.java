package com.capstone.traveltogeorgia.data;

public enum Type {
    ADVENTURE("Adventure"),
    CULTURAL("Cultural"),
    NATURE("Nature");

    private final String displayName;

    Type(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}