package models;

import java.util.Date;

public class Interview {
    private Date date;
    private Location location;
    private Person interviewedPerson;

    public Interview(Person person, Location location, Date date) {
        this.interviewedPerson = person;
        this.location = location;
        this.date = date;
    }

    public Date getDate(){
        return this.date;
    }

    public Location getLocation(){
        return this.location;
    }

    public Person getInterviewedPerson(){
        return this.interviewedPerson;
    }
}
