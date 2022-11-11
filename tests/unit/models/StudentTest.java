package tests.unit.models;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import models.*;

public class StudentTest{
    private Student student;

    @Before
    public void init() {
        student = new Student("Matthew", 20);
    }

    @Test
    public void testGetName(){
        assertEquals(student.getName(), "Matthew");
    }
    @Test
    public void testGetAge(){
        assertEquals(student.getAge(), 20);
    }
    @Test
    public void testSetAge(){
        student.setAge(20);
        assertEquals(30, student.getAge());
    }
}