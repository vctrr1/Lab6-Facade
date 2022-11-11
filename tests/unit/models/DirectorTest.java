package tests.unit.models;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import models.Director;
import models.Location;
import models.Person;
import models.Student;

public class DirectorTest {
    


    @Test
    public void theMeetingIsScheduled(){
        Director director = new Director("George", 44, 5000);

        ArrayList<Person> people = new ArrayList<>();
        people.add(new Student("Matthew", 0));
        Location location = new Location("B", 2, "A");
        

        director.scheduleMeeting(people, location, new Date());

        assertEquals(director.meetings)

    }
    @Test
    public void  testScheduleInterviews(){
    Director director = new Director("Marcos", 45, 2000);
    Location location = new Location("C", 2, "A");
    Person person = new Person ("Joanderson", 20);
    director.scheduleInterview(person, , null);
  
      





    }

    

}