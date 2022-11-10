package models;

public class Professor extends Person{

    private double wage;
  
    public Professor (String name, double wage){
        super(name);
        this.wage = wage;
        
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage){
        this.wage = wage;
    }
}