package org.newapp.antofucker.controller;

import org.newapp.antofucker.assignments.Deliverable;
import org.newapp.antofucker.service.assigmentservice.AssignmentService;
import org.newapp.antofucker.service.assigmentservice.MockAssignmentService;

/**
 * Created by pedroantoninho on 12/11/15.
 */
public class HomeworkController {

    AssignmentService homeworkService;

    public HomeworkController() {
        homeworkService = new MockAssignmentService();
    }


    /*//RECEBE HOMEWORK OU RECEBE INFO PARA HOMEWORK?
    public boolean addHomework(String title) {

        Homework hw = new Homework(title);
        if (homeworkService.findAssignment(hw.getAssignmentID()) != hw) {
            return true;
        }

        return true;
    }

    public boolean addDeliverable(int assignmentID, Deliverable deliverable) {

        if (homeworkService.findAssignment(assignmentID) instanceof Summarizer &&
                homeworkService.findAssignment(assignmentID).getDeliverables().size() > 0) {
            return false;
        }

        homeworkService.findAssignment(assignmentID).addDeliverable(deliverable);
        return true;
    }*/



}
