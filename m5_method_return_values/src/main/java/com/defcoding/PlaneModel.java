package com.defcoding;

public enum PlaneModel {

    BOEING737_800("Boeing 737-800"),
    BOEING737_700("Boeing 737-700"),
    AIRBUS_320("Airbus A320"),
    UNKNOWN("Unknown");


    private String model;

    PlaneModel(String model) {
        this.model = model;
    }

    @Override
    public String toString(){
        return model;
    }
}
