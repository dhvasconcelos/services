package org.newapp.antofucker.assignments.homework;

import org.newapp.antofucker.assignments.Assignment;
import org.newapp.antofucker.othershits.Bootcamp;

import java.util.Date;

/**
 * Created by cadet on 12/11/15.
 */
public class Homework extends Assignment {


    public Homework(String title) {
        super(title);
    }

    public Homework(Bootcamp bootcamp, Date creationDate, String title) {
        super(bootcamp, creationDate, title);
    }


}
