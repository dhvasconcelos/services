package org.newapp.antofucker.service.assigmentservice;

import org.newapp.antofucker.assignments.Assignment;
import org.newapp.antofucker.assignments.Deliverable;

import java.util.Collection;

/**
 * Created by cadet on 12/11/15.
 */
public interface AssignmentService {

    public int list();

    public void add (Assignment assignment);

    public void remove(int assignmentID);

    public Assignment findAssignment(int assignmentID);

    public Deliverable findDeliverable(int assignmentID,String username);

    public void updateAssignment(int assignmentID, Assignment newAssignment);

    public void updateDeliverable(int assignmentID, Deliverable deliverable, Deliverable newDeliverable);
}
