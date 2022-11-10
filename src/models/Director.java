package models;

import java.util.ArrayList;

public class Director extends Person{
    
    public ArrayList<Meeting> meetings;
    public ArrayList<Interview> interviews;

    public Director(String name){
        super(name);
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
}

