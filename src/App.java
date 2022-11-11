import java.util.ArrayList;
import java.util.Scanner;

import controllers.Facade;
import models.Course;
import models.Location;
import models.Registry;
import repositories.CourseRepository;
import repositories.LocationRepository;
import repositories.RegistryRepository;
import utils.MockData;

public class App {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        // we are gonna call the facade here
        boolean loop = true;
        MockData.populateData();

        ArrayList<Registry> registries = RegistryRepository.list();
        ArrayList<Location> locations = LocationRepository.list();
        ArrayList<Course> courses = CourseRepository.list();

        while (loop) {
            System.out.println();
            System.out.println("1 - allocate location");
            System.out.println("2 - show paid acquisitions");
            System.out.println("3 - show future acquisitions");
            System.out.println("4 - show History");
            System.out.println("5 - show Registries");
            System.out.println("6 - show Professors");
            System.out.println("7 - show Enrollment Time");
            System.out.println("8 - show Account Balance");
            System.out.println("9 - show Payroll");
            System.out.println("10 - show Meetings");
            System.out.println("11 - show Interviews");
            System.out.println("12 - end Program");

            int option = scanner.nextInt();
            System.out.println();
            switch (option) {

                case 1:
                    Facade.allocateLocation(locations.get(0).getId(), courses.get(2).getId());
                    break;

                case 2:
                    Facade.showAcquisitions();
                    break;

                case 3:
                    Facade.showFutureAcquisitions();
                    break;

                case 4:
                    Facade.showHistory(registries.get(0));
                    break;

                case 5:
                    Facade.showRegistry(registries.get(0));
                    break;

                case 6:
                    Facade.showProfessorCourses();
                    break;

                case 7:
                    Facade.showEnrollmentTime();
                    break;

                case 8:
                    Facade.showBalance();
                    break;

                case 9:
                    Facade.showPayroll();
                    break;

                case 10:
                    Facade.showMeetings();
                    break;

                case 11:
                    Facade.showInterviews();
                    break;

                case 12:
                    loop = false;
                    break;

                default:
                    System.out.println("\nInvalid option.\n");
                    break;

            }
        }

    }
}
