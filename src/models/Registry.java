package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Registry {
    
    private Person person;
    private UUID id;
    private Date createdAt;
    private ArrayList<Course> courses;

    public Registry(Person person){
        this.person = person;
        this.id = UUID.randomUUID();
        this.createdAt = new Date();
    }

    public ArrayList<Course> getCourses(){
        return this.courses;
    }

    public Date getCreatedAt(){
        return this.createdAt;
    }

    public Person getPerson(){
        return this.person;
    }

    public String getId(){
        return this.id.toString();
    }
}
