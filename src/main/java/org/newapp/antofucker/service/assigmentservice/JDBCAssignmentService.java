package org.newapp.antofucker.service.assigmentservice;

import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.newapp.antofucker.assignments.Assignment;
import org.newapp.antofucker.assignments.Deliverable;
import org.newapp.antofucker.assignments.homework.Homework;
import org.newapp.antofucker.assignments.summarizer.Summarizer;
import org.newapp.antofucker.persistance.ConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

/**
 * Created by cadet on 13/11/15.
 */
public class JDBCAssignmentService implements AssignmentService {
    Connection dbConnection = ConnectionManager.getConnection();

    @Override
    public int list() {
        int count = 0;

        try {
            Statement statement = dbConnection.createStatement();

            String query = "SELECT COUNT(*) FROM assignment";

            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }

            statement.close();

        } catch (SQLException e) {
            System.out.println("Failure counting results: " + e.getMessage());
        }

        return count;
    }


    @Override
    public void add(Assignment assignment) {

        try {
            Statement statement = dbConnection.createStatement();

            System.out.println(assignment.getClass().getSimpleName());

            String query = "SELECT assignment_type_id FROM assignment_type WHERE name='" + assignment.getClass().getSimpleName() + "';";
            ResultSet resultSet = statement.executeQuery(query);


            if (resultSet.next()) {
                int type = resultSet.getInt(1);
                System.out.println(type);
                String insertQuery = "INSERT INTO assignment (assignment_type_id, bootcamp_id, creation_date, title)  VALUES ('" +
                        type + "', '" +
                        assignment.getBootcamp() + "', '" +
                        assignment.getCreationDate() + "', '" +
                        assignment.getTitle() + "');";

                statement.execute(insertQuery);
            }

            statement.close();

        } catch (SQLException e) {
            System.out.println("Failure adding user: " + e.getMessage());
        }
    }

    @Override
    public void remove(int assignmentID) {
        
    }

    @Override
    public Assignment findAssignment(int assignmentID) {
        return null;
    }

    @Override
    public Deliverable findDeliverable(int assignmentID, String username) {
        return null;
    }

    @Override
    public void updateAssignment(int assignmentID, Assignment newAssignment) {

    }

    @Override
    public void updateDeliverable(int assignmentID, Deliverable deliverable, Deliverable newDeliverable) {

    }
}
