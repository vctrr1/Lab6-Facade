package tests.unit.models;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import models.*;

public class DirectorTest {

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
    public void isTheMeetingScheduled() {
        people.add(student);
        director.scheduleMeeting(people, location, new Date());
        assertEquals(director.meetings.get(0), student);

    }

    @Test
    public void isTheInterviewScheduled() {
        director.scheduleInterview(professor, location, new Date());
        assertEquals(director.interviews.get(0), professor);
    }

    @Test
    public void testGetName() {
        assertEquals("Fred", director.getName());
    }

    @Test
    public void testGetAge() {
        assertEquals(28, director.getAge());
    }

    @Test
    public void testGetWage() {
        assertEquals((int) director.getWage(), 2000);
    }

    @Test
    public void testSetAge() {
        director.setAge(30);
        assertEquals(30, director.getAge());
    }

    @Test
    public void testSetWage() {
        director.setAge(9000);
        assertEquals((int) director.getWage(), 9000);
    }
}