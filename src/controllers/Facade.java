package controllers;

import java.util.ArrayList;

import interfaces.Employee;
import models.*;
import repositories.RegistryRepository;
import repositories.AcquisitionRepository;
import repositories.CourseRepository;

public class Facade {

    Director director;
    Professor professor;
    Student sdt1, sdt2, sdt3, sdt4;
  
    
    FinancialController financialController;
    Location location;

    private static ArrayList<Registry> registries = RegistryRepository.list();
    private static ArrayList<Acquisition> acquisitions = AcquisitionRepository.list();

    private static double acquisitionsBalance = 0;
    private static double salaryBalance = 0;

    public Facade(Director director, Professor professor, Student student,
            FinancialController financialController) {

        this.director = director;
        this.professor = professor;
        this.sdt1 = student;
      
        this.financialController = financialController;

    }

    public void newCourse(String name, Registry prof, Location location) {
        CourseRepository.store(name, prof.getId(), location.getId());
        System.out.println("New Course was created");
    }

    public void showProfessorCourses(){
        ArrayList<Course> courses = CourseRepository.list();
        
        
    }

    public void showStudentCourses(Registry student) {
        student.getCourses().toString();
    }

    public void showPayroll() {
        System.out.println("\n[");
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

    public void allocateLocation(String locationId, String courseId) {
        CourseRepository.update("", "", locationId, courseId);
    }

    // Calculate employee wages // folha de pagamento
    public static void sumEmployeesWage() {

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

    public void showAcquisitions() {
        ArrayList<Acquisition> acquisition = AcquisitionRepository.list();

        for (int i = 0; i < acquisition.size(); i++) {
            if (acquisition.get(i).getIsPaid()) {
                System.out.printf("\t%d: {\n", i);
                System.out.printf("\t\tName: %s,\n", acquisition.get(i).getName());
                System.out.printf("\t\tPrice: %s,\n", acquisition.get(i).getValue());
                System.out.printf("\t\tIs paid: %s,\n", acquisition.get(i).getIsPaid());
            }
        }
    }

    public void showFutureAcquisitions() {
        ArrayList<Acquisition> acquisition = AcquisitionRepository.list();

        for (int i = 0; i < acquisition.size(); i++) {
            if (!acquisition.get(i).getIsPaid()) {
                System.out.printf("\t%d: {\n", i);
                System.out.printf("\t\tName: %s,\n", acquisition.get(i).getName());
                System.out.printf("\t\tPrice: %s,\n", acquisition.get(i).getValue());
                System.out.printf("\t\tIs paid: %s,\n", acquisition.get(i).getIsPaid());
            }
        }
    }

    public void showHistory(Registry student) {
        ArrayList<Registry> registries = RegistryRepository.list();

        for (int i = 0; i < registries.size(); i++) {
            if (student.getId().equals(registries.get(i).getId())) {
                for(int j = 0; j < registries.get(i).getCourses().size(); j++){
                    System.out.printf("\t%d: {\n", j);
                    System.out.printf("\t\tName: %s,\n", registries.get(j).getHistory().getFormerCourses().get(j).getTitle());
                    System.out.printf("\t\tID: %s,\n", registries.get(j).getHistory().getFormerCourses().get(j).getId());
                    
                }
            }
        }
    }

    public void showRegistry(Registry student) {
        ArrayList<Registry> registries = RegistryRepository.list();

        for (int i = 0; i < registries.size(); i++) {
            if (student.getId().equals(registries.get(i).getId())) {
                for(int j = 0; j < registries.get(i).getCourses().size(); j++){
                    System.out.printf("\t%d: {\n", j);
                    System.out.printf("\t\tName: %s,\n", registries.get(j).getCourses().get(j).getTitle());
                    System.out.printf("\t\tName: %s,\n", registries.get(j).getCourses().get(j).getId());
                }
            }
        }
    }
}