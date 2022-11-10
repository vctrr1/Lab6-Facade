package repositories;

import java.util.ArrayList;

import models.Director;
import models.Professor;
import models.Registry;
import models.Student;
import utils.Constraints;

public class RegistryRepository {

    private static ArrayList<Registry> registries = new ArrayList<>();

    public RegistryRepository() {

    }

    public static boolean store(String name, int age) {
        if (!(Constraints.isValidName(name) && Constraints.isValidAge(age)))
            return false;
        registries.add(new Registry(new Student(name, age)));
        return true;
    }

    public static boolean store(String name, int age, double wage) {
        if (!(Constraints.isValidName(name) && Constraints.isValidAge(age) && Constraints.isValidWage(wage)))
            return false;
        registries.add(new Registry(new Director(name, age, wage)));
        return true;
    }

    public static boolean store(String name, int age, double wage, boolean isTemporary) {
        if (!(Constraints.isValidName(name) && Constraints.isValidAge(age) && Constraints.isValidWage(wage)))
            return false;
        registries.add(new Registry(new Professor(name, age, wage, isTemporary)));
        return true;
    }

    public static boolean update(int age, String id) {
        if (!(Constraints.isValidID(id)))
            return false;
        for (int i = 0; i < registries.size(); i++) {
            if (registries.get(i).getId().equals(id)) {
                registries.get(i).getPerson().setAge(age);
                return true;

            }
        }

        return false;
    }

    public static boolean update(int age, double wage, String id) {
        if (!Constraints.isValidID(id))
            return false;

        for (int i = 0; i < registries.size(); i++) {
            if (registries.get(i).getId().equals(id)) {
                if (Constraints.isValidAge(age))
                    registries.get(i).getPerson().setAge(age);
                if (Constraints.isValidWage(wage))
                    ((Director) registries.get(i).getPerson()).setWage(wage);
                return true;

            }
        }

        return false;
    }

    public static boolean update(int age, double wage, boolean isTemporary, String id) {
        if (!Constraints.isValidID(id))
            return false;

        for (int i = 0; i < registries.size(); i++) {
            if (registries.get(i).getId().equals(id)) {
                if (Constraints.isValidAge(age))
                    registries.get(i).getPerson().setAge(age);
                if (Constraints.isValidWage(wage))
                    ((Professor) registries.get(i).getPerson()).setWage(wage);

                ((Professor) registries.get(i).getPerson()).setIsTemporary(isTemporary);

                return true;

            }
        }

        return false;
    }

    public static Registry findOne(String id) {
        if (!Constraints.isValidID(id))
            return null;
        for (int i = 0; i < registries.size(); i++) {
            if (registries.get(i).getId().equals(id)) {
                return registries.get(i);

            }
        }

        return null;

    }

    public static ArrayList<Registry> list() {
        return registries;
    }

    public static boolean delete(String id) {
        if (!Constraints.isValidID(id))
            return false;
        for (int i = 0; i < registries.size(); i++) {
            if (registries.get(i).getId().equals(id)) {

                registries.remove(registries.get(i));
                return true;
            }
        }

        return false;

    }

}