package repositories;

import java.util.ArrayList;

import models.Student;
import utils.Constraints;

public class StudentRepository{

    private static ArrayList<Student> students = new ArrayList<>();

    public StudentRepository(){
        
    }

    public static boolean store(String name) {
        if(!Constraints.isValidName(name)) return false;
        students.add(new Student(name));
        return true;
    } 

    public static boolean update(ArrayList<Course> currentCourses, String studenId ) {
        i
        students.add(new Student(name));
        return true;
    } 

    public static Student findOne(String id) {
        if (!Constraints.isValidID(id)) return null;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {
                return students.get(i);
              
            }
        }

        return null;

    }

    public static ArrayList<Student> list(){
        return students;
    }

    public static boolean delete(String id) {
         if (!Constraints.isValidID(id)) return false;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {

                students.remove(students.get(i));
                return true;
            }
        }

        return false;

    }

}