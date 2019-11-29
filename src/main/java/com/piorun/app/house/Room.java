package com.piorun.app.house;

public enum Room {
    KITCHEN("kuchnie"),
    BATHROOM("łazienkę"),
    HALL("przedpokój");

    Room(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }
}
