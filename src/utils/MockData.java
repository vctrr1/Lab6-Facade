package utils;

import java.util.ArrayList;

import models.Acquisition;
import models.Course;
import models.Location;
import models.Registry;
import repositories.*;


public class MockData{
    
    public MockData(){

    }

    public static void populateData(){
        RegistryRepository.store("John", 18);
        RegistryRepository.store("Mary", 19);
        RegistryRepository.store("Jhin", 27, 8000, false);
        RegistryRepository.store("Mark", 42, 1000, true);
        RegistryRepository.store("Frederick", 26, 4500);

        LocationRepository.store("A1", 1, "3965");
        LocationRepository.store("A1", 2, "2108");
        LocationRepository.store("A1", 3, "9748");

        LocationRepository.store("B2", 1, "1032");
        LocationRepository.store("B2", 2, "3332");
        LocationRepository.store("B2", 3, "4533");
        LocationRepository.store("B2", 3, "4511");

        LocationRepository.store("C3", 1, "4481");
        LocationRepository.store("C3", 2, "2142");
        LocationRepository.store("C3", 3, "3011");
        LocationRepository.store("C3", 3, "2021");

        ArrayList<Location> locations = LocationRepository.list();
        ArrayList<Registry> registries = RegistryRepository.list();

        ArrayList<Course> courses = CourseRepository.list();
        ArrayList<Acquisition> acquisitions = AcquisitionRepository.list();

        CourseRepository.store("Map I", registries.get(2).getId(), locations.get(0).getId());
        CourseRepository.store("Map II", registries.get(2).getId(), locations.get(5).getId());
    
        CourseRepository.store("Algorithm", registries.get(3).getId(), locations.get(3).getId());
        CourseRepository.store("Lab I", registries.get(3).getId(), locations.get(4).getId());
    
        registries.get(0).getCourses().add(courses.get(0));
        registries.get(0).getCourses().add(courses.get(1));
        registries.get(0).getHistory().getFormerCourses().add(courses.get(2));
        registries.get(0).getHistory().getFormerCourses().add(courses.get(3));


        AcquisitionRepository.store("Pants", 50);
        AcquisitionRepository.store("Trousers", 74.50);
        AcquisitionRepository.store("Food", 200);
        AcquisitionRepository.store("Paint", 1000);

    }
}