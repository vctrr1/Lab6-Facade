package models;

import java.util.UUID;
import java.util.Date;

public class Person {

    private String name;
    private UUID id;
    private Date enrolledAt;


    public Person (String name){
        this.name = name;
        this.id = UUID.randomUUID();
        this.enrolledAt = new Date();
    }

    public Date enrolledAt(){
        return enrolledAt;
    }


    public String getId(){
        return this.id.toString();
    }

    protected String getName(){
        return this.name;
    }

}