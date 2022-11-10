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

    public static boolean isValidAge(int age){
        return age > 17 && age < 90;
    }

    public static boolean isValidFloor(int floor){
        return floor > 0 && floor < 7;
    }

    public static boolean isValidSeries(String series){
        int length = series.length();
        if(series.matches("[^A-Za-z0-9]+"))
            return false;
        return length > 3 && length < 12;
    }

    public static boolean isValidBlock(String block){
        int length = block.length();
        return length > 1 && length < 10;
    }

    public static boolean isValidID(String supposedId){
        return UUID.fromString(supposedId).toString().equals(supposedId);
    }

}