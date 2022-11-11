package tests.unit.models;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;

import models.*;

public class RegistryTest {
    
    private Person person;
    private Date createdAt;
    private ArrayList<Course> courses;
    private History history;

    Director director;
    Professor professor;
    Student student;

    @Before
    public void init() {
        person = new Person("Rafael", 21);
        director = new Director("George", 44, 5000);
        professor = new Professor("Fred", 28, 2000, true);
        student = new Student("Matthew", 20);
        this.history = new History();
    }

    public void testStudent(){
        Registry registry = new Registry(student);
        assertEquals(student, registry.getPerson());
    }

    public void testProfessor(){
        Registry registry = new Registry(professor);
        assertEquals(professor, registry.getPerson());
    }

    public void testDirector(){
        Registry registry = new Registry(director);
        assertEquals(director, registry.getPerson());
    }
}