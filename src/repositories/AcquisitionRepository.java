package repositories;

import java.util.ArrayList;

import models.Acquisition;
import utils.Constraints;

public class AcquisitionRepository{

    private static ArrayList<Acquisition> acquisitions = new ArrayList<>();

    public AcquisitionRepository(){

    }

    public static boolean store(String name, double value) {
        
        acquisitions.add(new Acquisition(name, value));
        return true;
    } 

    public static boolean update(String name, double value, String acquisitionId ) {
        
        //acquisitions.add();
        return true;
    } 

    public static Acquisition findOne(String id) {
        //if (new DoctorMiddleware().validFindOne(id))
        //    return false;
        for (int i = 0; i < acquisitions.size(); i++) {
            if (acquisitions.get(i).getId().equals(id)) {
                return acquisitions.get(i);
              
            }
        }

        return null;

    }

    public static ArrayList<Acquisition> list(){
        return acquisitions;
    }

    public static boolean delete(String id) {
         if (!Constraints.isValidID(id)) return false;
        for (int i = 0; i < acquisitions.size(); i++) {
            if (acquisitions.get(i).getId().equals(id)) {

                acquisitions.remove(acquisitions.get(i));
                return true;
            }
        }

        return false;

    }

}