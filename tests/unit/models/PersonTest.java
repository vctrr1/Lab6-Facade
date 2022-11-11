package tests.unit.models;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import models.*;

public class PersonTest{
    private Person person;

    @Before
    public void init() {
        person = new Person("Rafael", 20);
    }

    @Test
    public void testGetAge(){
        assertEquals(20 ,person.getAge());
    }
    @Test
    public void testGetName(){
        assertEquals("Rafael", person.getName());
    }



}