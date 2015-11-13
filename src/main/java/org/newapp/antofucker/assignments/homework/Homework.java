package org.newapp.antofucker.assignments.homework;

import org.newapp.antofucker.assignments.Assignment;
import org.newapp.antofucker.othershits.Bootcamp;

import java.util.Date;

/**
 * Created by cadet on 12/11/15.
 */
public class Homework extends Assignment {

    static private int mockHomeworkID = 0;

    public Homework(String title) {
        super(title);
    }

    public Homework(Date creationDate, String title, int assignmentID) {
        super(creationDate, title, assignmentID);
    }
}
