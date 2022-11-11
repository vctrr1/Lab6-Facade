package models;

import java.util.UUID;

public class Acquisition {

    private double value;
    private String name;
    private UUID id;
    private boolean isPaid;

    public Acquisition(String name, double value) {
        this.name = name;
        this.value = value;
        this.id = UUID.randomUUID();
        this.isPaid = false;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return this.value;
    }

    public boolean getIsPaid(){
        return this.isPaid;
    }

    public void setIsPaid(boolean isPaid){
        this.isPaid = isPaid;
    }

    public String getId() {
        return this.id.toString();
    }


}