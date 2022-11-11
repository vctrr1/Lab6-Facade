package tests.unit.models;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import models.*;

public class LocationTest {

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
    public void testGetLocationName() {
        assertEquals(location.getLocationName(), "B" + 2 + "A");
    }

    @Test
    public void testSetFloor() {
        location.setFloor(3);
        assertEquals(location.getLocationName(), "B" + 3 + "A");
    }

    @Test
    public void testSetSeries() {
        location.setSeries("re");
        assertEquals(location.getLocationName(), "B" + 2 + "re");
    }

    @Test
    public void testSetBlock() {
        location.setBlock("F");
        assertEquals(location.getLocationName(), "F" + 2 + "A");
    }

}