package com.piorun.app.house;

public enum Flatmate {
    PIORUN("maciej.piorun2@gmail.com", "Macieju"),
    ANIA("guren382@gmail.com", "Ania"),
    MROZEK("alekssa.frost@gmail.com", "Mrozuś"),
    STASIU("hubert.stachowski@gmail.com", "Stasiu");


    Flatmate(String address, String name) {
        this.address = address;
        this.name = name;
    }

    private String address;
    private String name;

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }
}

