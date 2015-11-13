import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.newapp.antofucker.assignments.Assignment;
import org.newapp.antofucker.assignments.Deliverable;
import org.newapp.antofucker.othershits.User;
import org.newapp.antofucker.persistance.ConnectionManager;
import org.newapp.antofucker.service.assigmentservice.AssignmentService;
import org.newapp.antofucker.service.assigmentservice.JDBCAssignmentService;
import org.newapp.antofucker.service.assigmentservice.MockAssignmentService;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 * Created by cadet on 12/11/15.
 */
public class HomeworkControllerTest {

    AssignmentService assignmentService = new JDBCAssignmentService();
    Connection dbConnection = ConnectionManager.getConnection();

    @Before
    public void resetDatabase() {
        try {
            Statement statement = dbConnection.createStatement();

            String deleteQuery = "DELETE FROM assignment WHERE assignment_id < 100;";
            String resetCounterQuery = "ALTER TABLE assignment AUTO_INCREMENT = 1;";

            statement.execute(deleteQuery);
            statement.execute(resetCounterQuery);

            statement.close();

        } catch (SQLException e) {
            System.out.println("Failure deleting assignment: " + e.getMessage());
        }
    }


    @Test
    public void testAddAssignment() {
        assignmentService.add(new Assignment("NEW_HW", "summarizer"));
        Assert.assertEquals(1, assignmentService.list());
    }

    @Test
    public void testAddAssignment2() {
        assignmentService.add(new Assignment("NEW_HW", "homework"));
        assignmentService.add(new Assignment("NEW_HW2", "homework"));
        assignmentService.add(new Assignment("NEW_HW3", "summarizer"));
        Assert.assertEquals(3, assignmentService.list());
    }

    @Test
    public void testFindAssignment() {
        assignmentService.add(new Assignment("NEW_HW", "summarizer"));
        Assignment assignment = assignmentService.findAssignment(1);
        Assert.assertEquals("NEW_HW", assignment.getTitle());
        Assert.assertEquals("summarizer", assignment.getAssignmentType());
        Assert.assertEquals(1, assignment.getAssignmentID());
    }

    @Test
    public void testRemoveAssignment() {
        assignmentService.add(new Assignment("NEW_HW", "homework"));
        assignmentService.add(new Assignment("NEW_HW2", "homework"));
        assignmentService.remove(1);


        Assert.assertEquals(1,assignmentService.list());
    }

    @Test
    public void testRemoveAssignment2() {
        assignmentService.add(new Assignment("NEW_HW", "homework"));
        assignmentService.add(new Assignment("NEW_HW2", "homework"));
        assignmentService.add(new Assignment("NEW_HW3", "summarizer"));
        assignmentService.remove(2);
        assignmentService.remove(3);

        Assert.assertEquals(1, assignmentService.list());
    }

/*
    @Test
    public void testUpdateAssignmentTitle() {
        Assignment hw = new Homework("HW_TO_UPDATE");
        assignmentService.add(hw);

        assignmentService.updateAssignment(hw.getAssignmentID(), new Assignment("NEW_HW"));
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

        assignmentService.updateDeliverable(hw.getAssignmentID(), del1, new Deliverable("antonious", "SQL", new Date(), "http://test.com"));

        Assert.assertEquals(del1.getUserName(),"antonious");

    }*/

}
