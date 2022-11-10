package repositories;

import java.util.ArrayList;

import models.Course;
import models.Location;
import models.Professor;
import models.Registry;
import utils.Constraints;

public class CourseRepository {

    private static ArrayList<Course> courses = new ArrayList<>();

    public CourseRepository() {

    }

    public static boolean store(String title, String professorId, String locationId) {
        if (!(Constraints.isValidTitle(title) && Constraints.isValidID(professorId)
                && Constraints.isValidID(locationId)))
            return false;
        Registry professor = RegistryRepository.findOne(professorId);
        if (professor == null)
            return false;
        if (!(professor.getPerson() instanceof Professor))
            return false;

        Location location = LocationRepository.findOne(locationId);
        if (location == null)
            return false;

        courses.add(new Course(title, professor, location));
        return true;
    }

    public static boolean update(String title, String professorId, String locationId, String courseId) {
        if (!Constraints.isValidID(courseId))
            return false;

        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId().equals(courseId)) {
                if (true)
                    courses.get(i).setTitle(title);

                if (Constraints.isValidID(professorId)) {
                    Registry professor = RegistryRepository.findOne(professorId);
                    if (professor != null)

                        if (professor.getPerson() instanceof Professor)
                            courses.get(i).setProfessor(professor);
                    ;
                }

                if (Constraints.isValidID(locationId)) {
                    Location location = LocationRepository.findOne(locationId);
                    if (location != null)
                        courses.get(i).setLocation(location);
                }

                return true;
            }
        }

        return false;

    }

    public static Course findOne(String id) {
        if (!Constraints.isValidID(id))
            return null;
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId().equals(id)) {
                return courses.get(i);

            }
        }

        return null;

    }

    public static ArrayList<Course> list() {
        return courses;
    }

    public static boolean delete(String id) {
        if (!Constraints.isValidID(id))
            return false;
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId().equals(id)) {

                courses.remove(courses.get(i));
                return true;
            }
        }

        return false;

    }

}