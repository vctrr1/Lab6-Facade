package utils;

import java.util.UUID;

public class Constraints {

    public static boolean isValidName(String name){
        int length = name.length();
        return length > 2 && length < 21;
    }

    public static boolean isValidTitle(String title){
        int length = title.length();
        return length > 2 && length < 50;
    }

    public static boolean isValidWage(double wage){
        return wage > 0 && wage < 1000000;
    }

    public static boolean isValidClassroom(String classroom){
        int length = classroom.length();
        return length > 2 && length < 50;
    }

    public static boolean isValidID(String supposedId){
        return UUID.fromString(supposedId).toString().equals(supposedId);
    }

}