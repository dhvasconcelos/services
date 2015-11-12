package org.newapp.antofucker.service.assigmentservice;

import org.newapp.antofucker.assignments.Assignment;
import org.newapp.antofucker.assignments.Deliverable;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by cadet on 12/11/15.
 */
public class MockAssignmentService implements AssignmentService {

    HashMap<String, Assignment> assignments = new HashMap<>();

    public MockAssignmentService() {
    }

    @Override
    public Collection<Assignment> list() {
        return assignments.values();
    }

    @Override
    public void add(Assignment assignment) {
        assignments.put(assignment.getTitle(), assignment);
    }

    @Override
    public void remove(Assignment assignment) {
        assignments.remove(assignment.getTitle());
    }

    @Override
    public Assignment find(String string) {

        return assignments.get(string);
    }

    @Override
    public void updateAssignment(Assignment assignment, Assignment newAss) {
        assignment.setTitle(newAss.getTitle());
    }

    @Override
    public void updateDeliverable(Assignment assignment, Deliverable deliverable, Deliverable newDeliverable) {

        assignments.get(assignment.getTitle())
                .getDeliverable(deliverable.getUser())
                .setTitle(newDeliverable.getTitle());

        assignments.get(assignment.getTitle())
                .getDeliverable(deliverable.getUser())
                .setDeliveryDate(newDeliverable.getDeliveryDate());

        assignments.get(assignment.getTitle())
                .getDeliverable(deliverable.getUser())
                .setTags(newDeliverable.getTags());


        assignments.get(assignment.getTitle())
                .getDeliverable(deliverable.getUser())
                .setUser(newDeliverable.getUser());
    }
}
