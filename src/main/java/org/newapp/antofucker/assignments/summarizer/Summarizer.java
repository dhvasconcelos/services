package org.newapp.antofucker.assignments.summarizer;


import org.newapp.antofucker.assignments.Assignment;
import org.newapp.antofucker.assignments.Deliverable;
import org.newapp.antofucker.othershits.Bootcamp;
import org.newapp.antofucker.othershits.User;

import java.util.Date;

/**
 * Created by cadet on 12/11/15.
 */
public class Summarizer extends Assignment {

    public Summarizer(String title, User user) {
        super(title);

        addDeliverable(new Deliverable(user));
    }

    public Summarizer(Bootcamp bootcamp, Date creationDate, String title) {
        super(bootcamp, creationDate, title);
    }


}
