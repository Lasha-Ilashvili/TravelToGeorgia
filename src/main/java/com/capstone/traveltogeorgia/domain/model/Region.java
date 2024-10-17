package com.capstone.traveltogeorgia.domain.model;

public enum Region {
    IMERETI("Imereti"),
    GURIA("Guria"),
    MTSKHETA_MTIANETI("Mtskheta-Mtianeti");

    private final String displayName;

    Region(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}