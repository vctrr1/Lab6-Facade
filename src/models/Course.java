package models;

import java.util.ArrayList;
import java.util.UUID;

public class Course {
    
    private String title;
    private Professor professor;
    private ArrayList<Student> students;
    private String classroomName;
    private UUID id;

    public Course (String title, Professor professor, String classroomName){
        this.title = title;
        this.professor = professor;
        this.students = new ArrayList<>();
        this.classroomName = classroomName;
        this.id = UUID.randomUUID();
    }

    public String getTitle(){
        return this.title;
    }
    
    public String getId(){
        return this.id.toString();
    }

    public Professor getProfessor() {
        return professor;
    }

    public String getClassroomName(){
        return this.classroomName;
    }


}