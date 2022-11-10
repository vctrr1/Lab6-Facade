package models;

import java.util.UUID;

public class Acquisition {

    private double value;
    private String name;
    private UUID id;

    public Acquisition(String name, double value) {
        this.name = name;
        this.value = value;
        this.id = UUID.randomUUID();
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    public String getId() {
        return this.id.toString();
    }
}