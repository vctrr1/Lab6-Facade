package models;

import java.util.ArrayList;
import java.util.Date;

public class Meeting {
    private Date date;
    private Location location;
    private ArrayList<Person> people;

    public Meeting(Location location, Date date, ArrayList<Person> people){
        this.people = people;
        this.location = location;
        this.date = date;
    }

    public ArrayList<Person> getPeople(){
        return this.people;
    }

    public Location getLocation(){
        return this.location;
    }

    public Date getDate(){
        return this.date;
    }


    
}
