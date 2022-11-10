package models;

import java.util.ArrayList;

public class Director extends Person{
    
    public ArrayList<Meeting> meetings;
    public ArrayList<Interview> interviews;

    private double wage;

    public Director(String name, int age, double wage){
        super(name, age);
        this.wage = wage;
        this.meetings = new ArrayList<>();
        this.interviews = new ArrayList<>();
    }


    private class Meeting {
        String date;
        String location;
        ArrayList<Person> people = new ArrayList<>();
        
    }

    private class Interview {
        String date;
        Person interviewedPerson;
    
        public Interview (Person person, String date){
            this.interviewedPerson = person;
            this.date = date;
        }
    }

    public void setWage(double wage){
        this.wage = wage;
    }

    public double getWage(){
        return this.wage;
    }
}

