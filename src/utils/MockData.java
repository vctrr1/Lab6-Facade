package utils;

import java.util.ArrayList;

import models.Location;
import models.Registry;
import repositories.*;


public class MockData{
    
    public MockData(){

    }

    public static void populateData(){
        RegistryRepository.store("John", 18);
        RegistryRepository.store("Jhin", 27, 8000, false);
        RegistryRepository.store("Mark", 42, 1000, true);
        RegistryRepository.store("Frederick", 26, 4500);

        LocationRepository.store("A", 1, "365");
        LocationRepository.store("A", 2, "210");
        LocationRepository.store("A", 3, "978");

        LocationRepository.store("B", 1, "102");
        LocationRepository.store("B", 2, "333");
        LocationRepository.store("B", 3, "453");
        LocationRepository.store("B", 3, "451");

        LocationRepository.store("C", 1, "448");
        LocationRepository.store("C", 2, "214");
        LocationRepository.store("C", 3, "301");
        LocationRepository.store("C", 3, "201");

        ArrayList<Location> locations = LocationRepository.list();
        ArrayList<Registry> registries = RegistryRepository.list();

        CourseRepository.store("Map I", registries.get(1).getId(), locations.get(0).getId());
        CourseRepository.store("Map II", registries.get(1).getId(), locations.get(0).getId());
    
        CourseRepository.store("Algorithm", registries.get(3).getId(), locations.get(3).getId());
        CourseRepository.store("Lab I", registries.get(3).getId(), locations.get(4).getId());
    

        AcquisitionRepository.store("Pants", 50);
        AcquisitionRepository.store("Trousers", 74.50);
        AcquisitionRepository.store("Food", 200);
        AcquisitionRepository.store("Paint", 1000);
    }
}