package models;

import java.util.ArrayList;
import java.util.Date;

import interfaces.Employee;

public class Director extends Person implements Employee{
    

    public ArrayList<Meeting> meetings;
    public ArrayList<Interview> interviews;

    private double wage;

    public Director(String name, int age, double wage){
        super(name, age);
        this.wage = wage;
        this.meetings = new ArrayList<>();
        this.interviews = new ArrayList<>();
    }
    
    public void scheduleMeeting(ArrayList<Person> people, Location location, Date date){
        meetings.add(new Meeting(location, date, people));
        
    }

    public void scheduleInterview(Person person, Location location, Date date){
        interviews.add(new Interview(person, location, date));
    }

    public void setWage(double wage){
        this.wage = wage;
    }

    public double getWage(){
        return this.wage;
    }

    

}

