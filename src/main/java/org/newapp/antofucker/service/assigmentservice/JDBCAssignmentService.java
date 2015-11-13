package org.newapp.antofucker.service.assigmentservice;


import org.newapp.antofucker.assignments.Assignment;
import org.newapp.antofucker.assignments.Deliverable;
import org.newapp.antofucker.persistance.ConnectionManager;

import java.sql.*;

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

            String query = "SELECT assignment_type_id FROM assignment_type WHERE name='" + assignment.getAssignmentType() + "';";
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                int type = resultSet.getInt(1);
                String insertQuery = "INSERT INTO assignment (assignment_type_id, bootcamp_id, creation_date, title)  VALUES ('" +
                        type + "', '" +
                        assignment.getBootcamp() + "', '" +
                        assignment.getCreationDate() + "', '" +
                        assignment.getTitle() + "');";

                statement.execute(insertQuery);
            }


            statement.close();

        } catch (SQLException e) {
            System.out.println("Failure adding assignment: " + e.getMessage());
        }
    }

    @Override
    public void remove(int assignmentID) {
        try {
            Statement statement = dbConnection.createStatement();


            String deleteQuery = "DELETE FROM assignment WHERE assignment_id=" + assignmentID + ";";

            statement.execute(deleteQuery);

            statement.close();

        } catch (SQLException e) {
            System.out.println("Failure deleting assignment: " + e.getMessage());
        }
    }

    @Override
    public Assignment findAssignment(int assignmentID) {
        Assignment assignment = null;

        try {
            Statement statement = dbConnection.createStatement();

            String retrieveQuery = "SELECT * FROM assignment WHERE assignment_id=" + assignmentID + ";";

            ResultSet resultSet = statement.executeQuery(retrieveQuery);



            if (resultSet.next()) {
                Date creationDate = resultSet.getDate("creation_date");
                String title = resultSet.getString("title");
                System.out.println(creationDate + title);

                String idQuery = "SELECT name FROM assignment_type WHERE assignment_type_id=" + resultSet.getInt("assignment_type_id") + ";";
                ResultSet idResultSet = statement.executeQuery(idQuery);

                if(idResultSet.next()) {
                    String assignmentType = idResultSet.getString("name");
                    assignment = new Assignment(creationDate,
                            title,
                            assignmentID,
                            assignmentType);
                }
            }

            statement.close();

        } catch (SQLException e) {
            System.out.println("Failure retrieving assignment: " + e.getMessage());
        }

        return assignment;
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
