package repositories;

import java.util.ArrayList;

import models.Course;
import models.Professor;
import utils.Constraints;

public class CourseRepository{

    private static ArrayList<Course> courses = new ArrayList<>();

    public CourseRepository(){

    }

    public static boolean store(String title, String professorId, String classroom) {
        if(!(Constraints.isValidTitle(title) && Constraints.isValidClassroom(classroom))) return false;
        Professor professor = ProfessorRepository.findOne(professorId);
        if(professor == null)
            return false;

        courses.add(new Course(title, professor, classroom));
        return true;
    } 

    public static boolean update(String title, String professorId, String classroom, String courseId) {
        if (!Constraints.isValidID(professorId)) return false;
        Professor professor = ProfessorRepository.findOne(professorId);
        if(professor == null)
            return false;

        /*for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId().equals(courseId)) {
                if (validProperties[0])
                    courses.get(i).setName(name);

                if (validProperties[1])
                    ((Course) courses.get(i)).set(wage);

                return true;
            }
        }*/
        //return false;
        
        return true;
    } 

     public static Course findOne(String id) {
        if (!Constraints.isValidID(id)) return null;
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId().equals(id)) {
                return courses.get(i);
              
            }
        }

        return null;

    }

    public static ArrayList<Course> list(){
        return courses;
    }

    public static boolean delete(String id) {
         if (!Constraints.isValidID(id)) return false;
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId().equals(id)) {

                courses.remove(courses.get(i));
                return true;
            }
        }

        return false;

    }

}