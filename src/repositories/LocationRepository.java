package repositories;

import java.util.ArrayList;

import models.Location;
import utils.Constraints;

public class LocationRepository {

    private static ArrayList<Location> locations = new ArrayList<>();

    public LocationRepository() {

    }

    public static boolean store(String block, int floor, String series) {
        //System.out.printf("%b - %b - %b\n", Constraints.isValidBlock(block), Constraints.isValidFloor(floor), Constraints.isValidSeries(series));
        if (!(Constraints.isValidBlock(block) && Constraints.isValidFloor(floor) && Constraints.isValidSeries(series)))
            return false;
        locations.add(new Location(block, floor, series));
        return true;
    }

    public static boolean update(String block, int floor, String series, String id) {
        if (Constraints.isValidID(id))
            return false;
        for (int i = 0; i < locations.size(); i++) {
            if (locations.get(i).getId().equals(id)) {
                if (Constraints.isValidBlock(block))
                    locations.get(i).setBlock(block);
                if (Constraints.isValidFloor(floor))
                    locations.get(i).setFloor(floor);
                if (Constraints.isValidSeries(series))
                    locations.get(i).setSeries(series);

                return true;

            }
        }

        return false;
    }

    public static Location findOne(String id) {
        if (!Constraints.isValidID(id))
            return null;
        for (int i = 0; i < locations.size(); i++) {
            if (locations.get(i).getId().equals(id)) {
                return locations.get(i);

            }
        }

        return null;

    }

    public static ArrayList<Location> list() {
        return locations;
    }

    public static boolean delete(String id) {
        if (!Constraints.isValidID(id))
            return false;
        for (int i = 0; i < locations.size(); i++) {
            if (locations.get(i).getId().equals(id)) {

                locations.remove(locations.get(i));
                return true;
            }
        }

        return false;

    }

}