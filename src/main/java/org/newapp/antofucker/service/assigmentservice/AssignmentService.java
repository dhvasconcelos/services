package org.newapp.antofucker.service.assigmentservice;

import org.newapp.antofucker.assignments.Assignment;
import org.newapp.antofucker.assignments.Deliverable;

import java.util.Collection;

/**
 * Created by cadet on 12/11/15.
 */
public interface AssignmentService {

    public Collection<Assignment> list();

    public void add (Assignment assignment);

    public void remove(Assignment assignment);

    public Assignment find(int assignmentID);

    public void updateAssignment(Assignment assignment, Assignment newAssignment);

    public void updateDeliverable(Assignment assignment, Deliverable deliverable, Deliverable newDeliverable);
}
