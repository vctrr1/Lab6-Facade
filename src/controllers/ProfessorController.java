package controllers;

import java.util.ArrayList;

import models.*;
import repositories.*;

public class ProfessorController{
    
    ArrayList<Course> courses = CourseRepository.list();

    public ArrayList<Course> professorCourse(Professor professor){
        ArrayList<Course> matchedCourses = new ArrayList<>();
        for(int i = 0; i < courses.size(); i++){
            if(courses.get(i).getProfessor().getId().equals(professor.getId())){
                matchedCourses.add(courses.get(i));
            }
        }
        return matchedCourses;
    }
}