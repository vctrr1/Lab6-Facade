package tests.unit.models;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import models.*;

public class CourseTest{
    private String title;
    private Registry professor;
    private ArrayList<Registry> students;
    private Location location;
  
    @Before
     public void init() {
        title = ("Mat");
        location = new Location("B", 2, "A");
        students = new ArrayList<>();
        professor = new Registry(new Professor("Carlos", 23, 5000, false));
    }

    @Test
    public void testGetTitle(){
        assertEquals("Mat", title);
    }

    @Test
    public void testeGetId(){
        assertEquals("Carlos",professor);
    }

    @Test
    public void testGetLocation(){
        assertEquals("B",location.getBlock());
    }
}