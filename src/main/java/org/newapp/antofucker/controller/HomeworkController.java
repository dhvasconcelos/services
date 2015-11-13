package org.newapp.antofucker.controller;

import org.newapp.antofucker.assignments.Deliverable;
import org.newapp.antofucker.assignments.homework.Homework;
import org.newapp.antofucker.assignments.summarizer.Summarizer;
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


    //RECEBE HOMEWORK OU RECEBE INFO PARA HOMEWORK?
    public boolean addHomework(String title) {

        Homework hw = new Homework(title);
        if (homeworkService.find(hw.getAssignmentID()) != hw) {
            return true;
        }

        return true;
    }

    public boolean addDeliverable(int assignmentID, Deliverable deliverable) {

        if (homeworkService.find(assignmentID) instanceof Summarizer &&
                homeworkService.find(assignmentID).getDeliverables().size() > 0) {
            return false;
        }

        homeworkService.find(assignmentID).addDeliverable(deliverable);
        return true;
    }



}
