package models;

public class Professor extends Person{

    private double wage;
    private boolean isTemporary;
  
    public Professor (String name, int age, double wage, boolean isTemporary){
        super(name, age);
        this.wage = wage;
        this.isTemporary = isTemporary;
        
    }

    public double getWage() {
        return this.wage;
    }

    public boolean getIsTemporary(){
        return this.isTemporary;
    }

    public void setIsTemporary(boolean isTemporary){
        this.isTemporary = isTemporary;
    }

    public void setWage(double wage){
        this.wage = wage;
    }
}