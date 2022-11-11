package tests.unit.repositories;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import models.*;
import repositories.AcquisitionRepository;


public class AcquisitionRepositoryTest {
    
    private ArrayList<Acquisition> acquisitions;
    private Director director;
    private Student student;
    private Professor professor;
    private Location location;
    
    @Before
    public void init() {
        AcquisitionRepository.store("Pants", 20);
        location = new Location("B", 2, "A");
    }

    @Test 
    public void validStore(){
       
        acquisitions = AcquisitionRepository.list();
        Acquisition acquisition = AcquisitionRepository.findOne(acquisitions.get(0).getId());

        assertEquals("Fred", acquisition.getName());
        assertEquals(20, (int) acquisition.getValue());
    }

    @Test 
    public void invalidStoreValueTooLow(){
        assertEquals(false, AcquisitionRepository.store("Player", 0));
        acquisitions = AcquisitionRepository.list();
        Acquisition acquisition = AcquisitionRepository.findOne(acquisitions.get(1).getId());

        assertEquals(null, acquisition);

    }

    @Test 
    public void invalidStoreValueTooHigh(){
        assertEquals(false, AcquisitionRepository.store("Player", 100001));
        acquisitions = AcquisitionRepository.list();
        Acquisition acquisition = AcquisitionRepository.findOne(acquisitions.get(1).getId());

        assertEquals(null, acquisition);

    }

    @Test 
    public void invalidStoreNameTooShort(){
        assertEquals(false, AcquisitionRepository.store("Ps", 10));
        acquisitions = AcquisitionRepository.list();
        Acquisition acquisition = AcquisitionRepository.findOne(acquisitions.get(1).getId());

        assertEquals(null, acquisition);

    }

    @Test 
    public void invalidStoreNameTooLong(){
        assertEquals(false, AcquisitionRepository.store("More than 20 characters.", 10));
        acquisitions = AcquisitionRepository.list();
        Acquisition acquisition = AcquisitionRepository.findOne(acquisitions.get(1).getId());

        assertEquals(null, acquisition);

    }

    
    @Test 
    public void validNameUpdate(){
       
        acquisitions = AcquisitionRepository.list();
        Acquisition acquisition = AcquisitionRepository.findOne(acquisitions.get(0).getId());

        assertEquals(true, AcquisitionRepository.update("Trousers", acquisition.getId()));
        assertEquals("Trousers", acquisitions.get(0).getName());
      
    }

    @Test 
    public void validIsPaidUpdate(){
       
        acquisitions = AcquisitionRepository.list();
        Acquisition acquisition = AcquisitionRepository.findOne(acquisitions.get(0).getId());

        assertEquals(true, AcquisitionRepository.update("", false, acquisition.getId()));
        assertEquals(false, acquisitions.get(0).getIsPaid());
      
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