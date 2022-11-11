package tests.unit.models;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import models.*;

public class MeetingTest {
    private Date date;
    private Location location;
    private ArrayList<Person> people;
    private Director director;
    private Student student;
    private Professor professor;

    @Before
    public void init() {
        people = new ArrayList<>();
        professor = new Professor("Fred", 28, 2000, true);
        director = new Director("George", 44, 5000);
        student = new Student("Rafael", 19);
        location = new Location("B", 2, "A");
       
    }

    @Test
    public void testGetPeople() {
        people.add(student);
        people.add(professor);
        people.add(director);
        Meeting meeting = new Meeting(location, new Date(), people);
        assertEquals(people.get(0), student);
    }
    @Test
    public void testGetLocation(){
        Meeting meeting = new Meeting(location, new Date(), people);
        assertEquals(location.getLocation(), location);
    }
}