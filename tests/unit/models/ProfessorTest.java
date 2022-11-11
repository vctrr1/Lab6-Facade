package tests.unit.models;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import models.*;


public class ProfessorTest {
    
    private ArrayList<Person> people;
    private Director director;
    private Student student;
    private Professor professor;
    private Location location;
    
    @Before
    public void init() {
        people = new ArrayList<>();
        director = new Director("George", 44, 5000);
        professor = new Professor("Fred", 28, 2000, true);
        student = new Student("Matthew", 20);
        location = new Location("B", 2, "A");
    }

    @Test 
    public void testGetName(){
        assertEquals("Fred", professor.getName());
    }

    @Test 
    public void testGetAge(){
        assertEquals(28, professor.getAge());
    }
    
    
    @Test
    public void testGetWage(){
        assertEquals((int) professor.getWage(), 2000);          
    }


    @Test 
    public void testSetAge(){
        professor.setAge(30);
        assertEquals(30, professor.getAge());
    }
    
    
    @Test
    public void testSetWage(){
        professor.setAge(3000);
        assertEquals((int) professor.getWage(), 3000);          
    }
}