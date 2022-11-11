package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Registry {
    
    private Person person;
    private UUID id;
    private Date createdAt;
    private ArrayList<Course> courses;
    private History history;

    public Registry(Person person){
        this.person = person;
        this.id = UUID.randomUUID();
        this.createdAt = new Date();
        this.history = new History();
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

    public History getHistory(){
        return this.history;
    }

    public String getId(){
        return this.id.toString();
    }


}
