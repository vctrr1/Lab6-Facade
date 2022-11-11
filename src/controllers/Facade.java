package controllers;

import java.util.ArrayList;

import interfaces.Employee;
import models.*;
import repositories.RegistryRepository;
import repositories.AcquisitionRepository;
import repositories.CourseRepository;
import repositories.LocationRepository;

public class Facade {

    Director director;
    Professor professor;
    Student sdt1, sdt2, sdt3, sdt4;

    Location location;

    private static ArrayList<Registry> registries = RegistryRepository.list();
    private static ArrayList<Acquisition> acquisitions = AcquisitionRepository.list();

    private static double acquisitionsBalance = 0;

    public Facade(Director director, Professor professor, Student student) {

        this.director = director;
        this.professor = professor;
        this.sdt1 = student;

    }

    public static void allocateLocation(String locationId, String courseId) {
        CourseRepository.update("", "", locationId, courseId);
        String courseTitle = CourseRepository.findOne(courseId).getTitle();
        String locationName = LocationRepository.findOne(locationId).getLocationName();

        System.out.printf("The course %s is now allocated to %s\n", courseTitle, locationName);
    }

    public static void showAcquisitions() {
        ArrayList<Acquisition> acquisition = AcquisitionRepository.list();
        int count = 0;

        System.out.println("results:\n\t[");
        for (int i = 0; i < acquisition.size(); i++) {
            if (acquisition.get(i).getIsPaid()) {
                count++;
                System.out.printf("\t\t%d: {\n", i);
                System.out.printf("\t\t\tName: %s,\n", acquisition.get(i).getName());
                System.out.printf("\t\t\tPrice: %s,\n", acquisition.get(i).getValue());
                System.out.printf("\t\t\tIs paid: %s,\n", acquisition.get(i).getIsPaid());
                System.out.println("\t\t},");
            }
        }
        System.out.println("\t]");
        if (count == 0) {
            System.out.println("There are no paid acquisitions");

        }
    }

    public static void showFutureAcquisitions() {
        ArrayList<Acquisition> acquisition = AcquisitionRepository.list();
        int count = 0;

        System.out.println("results:\n\t[");
        for (int i = 0; i < acquisition.size(); i++) {

            if (!acquisition.get(i).getIsPaid()) {
                count++;
                System.out.printf("\t\t%d: {\n", i);
                System.out.printf("\t\t\tName: %s,\n", acquisition.get(i).getName());
                System.out.printf("\t\t\tPrice: %s,\n", acquisition.get(i).getValue());
                System.out.printf("\t\t\tIs paid: %s,\n", acquisition.get(i).getIsPaid());
                System.out.println("\t\t},");
            }
        }
        System.out.println("\t]");
        if (count == 0) {
            System.out.println("There are no future acquisitions");

        }
    }

    public static void showHistory(Registry registry) {
        ArrayList<Registry> registries = RegistryRepository.list();
        int count = 0;
        System.out.println("History");
        for (int i = 0; i < registries.size(); i++) {
            if (registry.getId().equals(registries.get(i).getId())) {

                System.out.printf("%s:\n\t[\n", registry.getPerson().getName());
                for (int j = 0; j < registries.get(i).getHistory().getFormerCourses().size(); j++) {
                    count++;

                    System.out.printf("\t\t%d: {\n", j);                 
                    System.out.printf("\t\t\tTitle: %s,\n",
                            registries.get(i).getHistory().getFormerCourses().get(j).getTitle());
                    System.out.printf("\t\t\tID: %s,\n",
                            registries.get(i).getHistory().getFormerCourses().get(j).getId());
                    System.out.println("\t\t},");
                }
                System.out.println("\t]");
            }
        }
        if (count == 0) {
            System.out.println("There are no courses registered in this history.");

        }
    }

    public static void showRegistry(Registry registry) {
        ArrayList<Registry> registries = RegistryRepository.list();
        int count = 0;

        System.out.println("Current Courses");
        for (int i = 0; i < registries.size(); i++) {
            if (registry.getId().equals(registries.get(i).getId())) {
                count++;
                System.out.printf("%s:\n\t[\n", registry.getPerson().getName());
                for (int j = 0; j < registries.get(i).getCourses().size(); j++) {
                    System.out.printf("\t\t%d: {\n", j);
                    System.out.printf("\t\t\tTitle: %s,\n", registries.get(i).getCourses().get(j).getTitle());
                    System.out.printf("\t\t\tLocation: %s,\n", registries.get(i).getCourses().get(j).getLocation().getLocationName());
                    System.out.printf("\t\t\tId: %s,\n", registries.get(i).getCourses().get(j).getId());
                    System.out.println("\t\t},");
                }
                System.out.println("\t]");
            }
        }
        if (count == 0) {
            System.out.println("There are no courses registered in this registry.");

        }
    }

    public static void showProfessorCourses() {
        ArrayList<Course> courses = CourseRepository.list();

    }

    public static void showEnrollmentTime() {

    }

    public static void showStudentCourses(Registry student) {
        student.getCourses().toString();
    }

    public static void showBalance() {
        System.out.println("\n[");
        double salaryBalance = 0;
        for (int i = 0; i < registries.size(); i++) {
            if (registries.get(i).getPerson() instanceof Employee) {
                salaryBalance += ((Employee) registries.get(i).getPerson()).getWage();

                System.out.printf("\t%d: {\n", i);
                System.out.printf("\t\tName: %s,\n", registries.get(i).getPerson().getName());
                System.out.printf("\t\tWage: %.2f,\n", ((Employee) registries.get(i).getPerson()).getWage());
                System.out.printf("\t},\n");

            }

            System.out.println("]");

        }

        System.out.println("\t\tTotal: " + salaryBalance);
    }

    public static void showPayroll() {
        System.out.println("\n[");
        double salaryBalance = 0;
        for (int i = 0; i < registries.size(); i++) {
            if (registries.get(i).getPerson() instanceof Employee) {
                salaryBalance += ((Employee) registries.get(i).getPerson()).getWage();

                System.out.printf("\t%d: {\n", i);
                System.out.printf("\t\tName: %s,\n", registries.get(i).getPerson().getName());
                System.out.printf("\t\tWage: %.2f,\n", ((Employee) registries.get(i).getPerson()).getWage());
                System.out.printf("\t},\n");

            }

            System.out.println("]");

        }

        System.out.println("\t\tTotal: " + salaryBalance);

        System.out.println("\n[");
        for (int i = 0; i < acquisitions.size(); i++) {
            acquisitionsBalance += acquisitions.get(i).getValue();

            System.out.printf("\t%d: {\n", i);
            System.out.printf("\t\tName: %s,\n", acquisitions.get(i).getName());
            System.out.printf("\t\tPrice: %.2f,\n", acquisitions.get(i).getValue());
            System.out.printf("\t},\n");
        }
        System.out.println("]");
        System.out.println("\t\tTotal: " + acquisitionsBalance);

        System.out.println(salaryBalance + salaryBalance);
    }

    public static void showMeetings() {
        ArrayList<Registry> registries = RegistryRepository.list();

        System.out.println("\n[");
        for (int i = 0; i < registries.size(); i++) {
            if (registries.get(i).getPerson() instanceof Director) {
                Director temp = ((Director) registries.get(i).getPerson());
                System.out.printf("\t\t%s: [\n", temp.getName());
                for (int k = 0; k < temp.meetings.size(); k++) {
                    System.out.println("\t\t\tpeople: [");
                    for (int j = 0; j < temp.meetings.get(k).getPeople().size(); j++) {
                        System.out.printf("\t\t\t\t%d: {\n", j);
                        System.out.printf("\t\t\t\tName: %s,\n", temp.meetings.get(k).getPeople().get(j).getName());

                        System.out.printf("\t\t\t},\n");
                    }
                    System.out.println("\t\t\t]");
                    System.out.printf("\t\t\tdate: %s\n", temp.meetings.get(k).getDate().toString());
                    System.out.printf("\t\t\tlocation: %s\n", temp.meetings.get(k).getLocation().getLocationName());

                }

            }
            System.out.println("\t\t]");

        }
        System.out.println("]");

    }

    public static void showInterviews() {
        ArrayList<Registry> registries = RegistryRepository.list();

        System.out.println("\n[");
        for (int i = 0; i < registries.size(); i++) {
            if (registries.get(i).getPerson() instanceof Director) {
                Director temp = ((Director) registries.get(i).getPerson());
                System.out.printf("\t\t%s: {\n", temp.getName());
                for (int k = 0; k < temp.interviews.size(); k++) {
                    System.out.printf("\t\t\tpeople: %s\n", temp.interviews.get(k).getInterviewedPerson().getName());
                    System.out.printf("\t\t\tdate: %s\n", temp.interviews.get(k).getDate().toString());
                    System.out.printf("\t\t\tlocation: %s\n", temp.interviews.get(k).getLocation().getLocationName());

                }

            }
            System.out.println("\t\t}");

        }
        System.out.println("]");

    }

}