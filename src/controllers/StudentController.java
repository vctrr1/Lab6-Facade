package controllers;

import java.util.ArrayList;
import models.*;
import repositories.*;

public class StudentController{
    ArrayList<Student> students = StudentRepository.list();

    private class Rdm {
        
    }


    //generates a RDM for a student
    public ArrayList<Course> generateRdm(Student student){
        ArrayList<Course> matchedCourses = new ArrayList<>();

        ArrayList<Course> currentCourses =  student.getCurrentCourses();
        for(int i = 0; i < currentCourses.size(); i++){
            if(!student.getFormerCourses().contains(currentCourses.get(i)) && matchedCourses.size() < 7)
                matchedCourses.add(currentCourses.get(i));
        }
        return matchedCourses;
    }
}