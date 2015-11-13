package org.newapp.antofucker.service.assigmentservice;

import org.newapp.antofucker.assignments.Assignment;
import org.newapp.antofucker.assignments.Deliverable;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by cadet on 12/11/15.
 */
public class MockAssignmentService implements AssignmentService {

    HashMap<Integer, Assignment> assignments = new HashMap<>();

    public MockAssignmentService() {
    }

    @Override
    public Collection<Assignment> list() {
        return assignments.values();
    }

    @Override
    public void add(Assignment assignment) {
        assignments.put(assignment.getAssignmentID(), assignment);
    }

    @Override
    public void remove(int assignmentID) {
        assignments.remove(assignmentID);
    }

    @Override
    public Assignment find(int assignmentID) {
        return assignments.get(assignmentID);
    }

    @Override
    public void updateAssignment(int assignmentID, Assignment newAss) {
        assignments.get(assignmentID).setTitle(newAss.getTitle());
    }

    @Override
    public void updateDeliverable(int assignmentID, Deliverable deliverable, Deliverable newDeliverable) {

        assignments.get(assignmentID)
                .getDeliverable(deliverable.getUserName())
                .setTitle(newDeliverable.getTitle());

        assignments.get(assignmentID)
                .getDeliverable(deliverable.getUserName())
                .setDeliveryDate(newDeliverable.getDeliveryDate());

        assignments.get(assignmentID)
                .getDeliverable(deliverable.getUserName())
                .setTags(newDeliverable.getTags());


        assignments.get(assignmentID)
                .getDeliverable(deliverable.getUserName())
                .setUserName(newDeliverable.getUserName());
    }
}
