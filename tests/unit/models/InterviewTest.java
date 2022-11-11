package tests.unit.models;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import models.*;

public class InterviewTest{
    private Date date;
    private Location location;
    private Person interviewedPerson;
    @Before

public void init() {
    location = new Location("A",2,"B");
    interviewedPerson = new Person("Rafael", 19);

    }

public void testGetAgeInterview(){
    assertEquals(interviewedPerson.getAge(), 19);
}
public void testGetNameInterview(){
    assertEquals(interviewedPerson.getName(),"Rafael");
}
public void testGetLocation(){
    assertEquals(location.getBlock(), "A");

}public void testGetLocation1(){
    assertEquals(location.getLocation(), "A" + 2 + "B");
    }
}