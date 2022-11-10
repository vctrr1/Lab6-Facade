package repositories;

import java.util.ArrayList;

import models.Course;
import models.Director;
import utils.Constraints;

public class DirectorRepository{

    private static ArrayList<Director> directors = new ArrayList<>();

    public DirectorRepository(){
        
    }

    public static boolean store(String name) {
        if(!Constraints.isValidName(name)) return false;
        directors.add(new Director(name));
        return true;
    } 

    public static boolean update(ArrayList<Course> currentCourses, String id ) {
        if (!Constraints.isValidID(id)) return false;
        for (int i = 0; i < directors.size(); i++) {
            if (directors.get(i).getId().equals(id)) {
                //directors.get(i).setCurrentCourses(currentCourses);
                return true;
              
            }
        }

        return false;
    } 

    public static Director findOne(String id) {
        if (!Constraints.isValidID(id)) return null;
        for (int i = 0; i < directors.size(); i++) {
            if (directors.get(i).getId().equals(id)) {
                return directors.get(i);
              
            }
        }

        return null;

    }

    public static ArrayList<Director> list(){
        return directors;
    }

    public static boolean delete(String id) {
         if (!Constraints.isValidID(id)) return false;
        for (int i = 0; i < directors.size(); i++) {
            if (directors.get(i).getId().equals(id)) {

                directors.remove(directors.get(i));
                return true;
            }
        }

        return false;

    }

}