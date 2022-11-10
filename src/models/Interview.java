package models;

import java.util.Date;

public class Interview {
    Date date;
    private Person interviewedPerson;

    public Interview(Person person, Date date) {
        this.interviewedPerson = person;
        this.date = date;
    }

    public Person getInterviewedPerson(){
        return this.interviewedPerson;
    }
}
