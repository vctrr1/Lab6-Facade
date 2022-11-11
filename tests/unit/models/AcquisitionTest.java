package tests.unit.models;

import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;
import models.*;

public class AcquisitionTest{
    private Acquisition acquisition;
  
    @Before
     public void init() {
        acquisition = new Acquisition("Hammer", 100);
    }

    @Test
    public void testGetName(){
        assertEquals("Hammer", acquisition.getName());
    }

    @Test
    public void testSetName(){
        acquisition.setName("Don");
        assertEquals("Don", acquisition.getName());
    }

    @Test
    public void testGetValue(){
        assertEquals((int) 100, (int) acquisition.getValue());
    }
}