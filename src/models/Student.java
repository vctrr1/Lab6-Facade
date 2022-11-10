package models;

import java.util.ArrayList;

public class Student extends Person {

    private ArrayList<Course> formerCourses;
    private ArrayList<Course> currentCourses;

    public Student (String name){
        super(name);
        this.formerCourses = new ArrayList<>();
        this.currentCourses = new ArrayList<>();
    }

    

    public ArrayList<Course> getFormerCourses(){
        return this.formerCourses;
    }

    public ArrayList<Course> getCurrentCourses(){
        return this.currentCourses;
    }

    public void setCurrentCourses(ArrayList<Course> currentCourses){
        this.currentCourses = currentCourses;
    }




}