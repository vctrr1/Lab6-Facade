package repositories;

import java.util.ArrayList;

import models.Professor;
import utils.Constraints;

public class ProfessorRepository{

    private static ArrayList<Professor> professors = new ArrayList<>();

    public ProfessorRepository(){

    }

    public static boolean store(String name, double wage) {
        if(!(Constraints.isValidName(name) && Constraints.isValidWage(wage))) return false;
        professors.add(new Professor(name, wage));
        return true;
    } 

    public static boolean update(double wage, String professorId ) {
        if(!(Constraints.isValidWage(wage))) return false;
          for (int i = 0; i < professors.size(); i++) {
            if (professors.get(i).getId().equals(professorId)) {
                professors.get(i).setWage(wage);
                return true;
              
            }
        }
       
        return false;
    } 

    public static Professor findOne(String id) {
        if (!Constraints.isValidID(id)) return null;
        for (int i = 0; i < professors.size(); i++) {
            if (professors.get(i).getId().equals(id)) {
                return professors.get(i);
              
            }
        }

        return null;

    }

    public static ArrayList<Professor> list(){
        return professors;
    }

    public static boolean delete(String id) {
        if (!Constraints.isValidID(id)) return false;
        for (int i = 0; i < professors.size(); i++) {
            if (professors.get(i).getId().equals(id)) {

                professors.remove(professors.get(i));
                return true;
            }
        }

        return false;

    }

}