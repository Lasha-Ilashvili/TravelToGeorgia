package com.capstone.traveltogeorgia.utils;


public class Utils {

    public static <T extends Enum<T>> T getEnum(Class<T> enumClass, String name) {
        for (T e : enumClass.getEnumConstants()) {
            if (e.toString().toUpperCase().contains(name.toUpperCase())) return e;
        }

        return null;
    }
}