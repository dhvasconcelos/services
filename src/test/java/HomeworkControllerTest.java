import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.newapp.antofucker.assignments.Assignment;
import org.newapp.antofucker.assignments.Deliverable;
import org.newapp.antofucker.assignments.homework.Homework;
import org.newapp.antofucker.othershits.User;
import org.newapp.antofucker.service.assigmentservice.AssignmentService;
import org.newapp.antofucker.service.assigmentservice.MockAssignmentService;

import java.util.Date;

/**
 * Created by cadet on 12/11/15.
 */
public class HomeworkControllerTest {

    AssignmentService assignmentService ;

    @Before
    public void createService() {
        assignmentService = new MockAssignmentService();
    }


    @Test
    public void testAddAssignment() {
        assignmentService.add(new Homework("NEW_HW"));
        Assert.assertEquals(1, assignmentService.list().size());
    }

    @Test
    public void testAddAssignment2() {
        assignmentService.add(new Homework("NEW_HW"));
        assignmentService.add(new Homework("NEW_HW2"));
        assignmentService.add(new Homework("NEW_HW3"));
        Assert.assertEquals(3, assignmentService.list().size());
    }

    @Test
    public void testRemoveAssignment() {
        Assignment hw = new Homework("HW_TO_DEL");
        assignmentService.add(hw);
        assignmentService.remove(hw);


        Assert.assertEquals(0,assignmentService.list().size());
    }

    @Test
    public void testRemoveAssignment2() {
        Assignment hw1 = new Homework("HW1_TO_DEL");
        Assignment hw2 = new Homework("HW2_TO_DEL");
        Assignment hw3 = new Homework("HW3_TO_DEL");
        assignmentService.add(hw1);
        assignmentService.add(hw2);
        assignmentService.add(hw3);

        assignmentService.remove(hw1);
        assignmentService.remove(hw2);

        Assert.assertEquals(1, assignmentService.list().size());
    }


    @Test
    public void testUpdateAssignmentTitle() {
        Assignment hw = new Homework("HW_TO_UPDATE");
        assignmentService.add(hw);

        assignmentService.updateAssignment(hw, new Assignment("NEW_HW"));
        Assert.assertEquals(hw.getTitle(),"NEW_HW");
    }


    @Test
    public void testUpdateDeliverableUser() {
        Assignment hw = new Homework("HOMEWORK_TITLE");
        Deliverable del1 = new Deliverable("anto","SQL",new Date(),"http://test.com");
        Deliverable del2 = new Deliverable("danielo","SQL",new Date(),"http://test.com");

        assignmentService.add(hw);
        hw.addDeliverable(del1);
        hw.addDeliverable(del2);

        assignmentService.updateDeliverable(hw, del1, new Deliverable("antonious", "SQL", new Date(), "http://test.com"));

        Assert.assertEquals(del1.getUserName(),"antonious");

    }

}
