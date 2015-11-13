package org.newapp.antofucker.assignments.summarizer;


import org.newapp.antofucker.assignments.Assignment;
import org.newapp.antofucker.assignments.Deliverable;

import java.sql.Date;


/**
 * Created by cadet on 12/11/15.
 */
public class Summarizer extends Assignment {


    public Summarizer(String title, String userName) {
        super(title);
        this.setAssignmentType("summarizer");

        addDeliverable(new Deliverable(userName));
    }

    public Summarizer(Date creationDate, String title, int assignmentID) {
        super(creationDate, title, assignmentID);
    }


}
