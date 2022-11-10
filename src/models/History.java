package models;

import java.util.ArrayList;

public class History {

    private ArrayList<Course> formerCourses;
    private ArrayList<Meeting> formerMeetings;
    private ArrayList<Interview> formerInterviews;
    
    public History(){
        formerCourses = new ArrayList<Course>();
        formerMeetings = new ArrayList<Meeting>();
        formerInterviews = new ArrayList<Interview>();
    }

    public ArrayList<Course> getFormerCourses(){
        return this.formerCourses;
    }

    public ArrayList<Meeting> getFormerMeetings(){
        return this.formerMeetings;
    }

    public ArrayList<Interview> getFormerInterviews(){
        return this.formerInterviews;
    }

}
