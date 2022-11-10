package models;

import java.util.ArrayList;
import java.util.UUID;

public class Course {
    
    private String title;
    private Registry professor;
    private ArrayList<Registry> students;
    private Location location;
    private UUID id;

    public Course (String title, Registry professor, Location location){
        this.title = title;
        this.professor = professor;
        this.students = new ArrayList<>();
        this.location = location;
        this.id = UUID.randomUUID();
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    
    public void setLocation(Location location){
        this.location = location;
    }

    public void setProfessor(Registry professor){
        this.professor = professor;
    }
    
    public String getId(){
        return this.id.toString();
    }

    public Registry getProfessor() {
        return professor;
    }

    public Location getLocation(){
        return this.location;
    }


}