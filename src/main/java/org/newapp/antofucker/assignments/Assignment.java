package org.newapp.antofucker.assignments;

import org.newapp.antofucker.othershits.Bootcamp;
import org.newapp.antofucker.othershits.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cadet on 12/11/15.
 */
public class Assignment {

    private Bootcamp bootcamp;
    private Date creationDate;
    private String title;
    private Map<String, Deliverable> deliverables = new HashMap<>();

    public Assignment(String title) {
        creationDate = new Date(System.currentTimeMillis());

        setTitle(title);
    }

    public Assignment (Bootcamp bootcamp, Date creationDate, String title) {
        this.bootcamp = bootcamp;
        this.creationDate = creationDate;
        this.title = title;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Bootcamp getBootcamp() {
        return bootcamp;
    }

    public void setBootcamp(Bootcamp bootcamp) {
        this.bootcamp = bootcamp;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void addDeliverable(Deliverable deliverable) {
        deliverables.put(deliverable.getUser().getUsername(),deliverable);
    }

    public Map<String, Deliverable> getDeliverables() {
        return deliverables;
    }

    public Deliverable getDeliverable(User user) {
        return deliverables.get(user.getUsername());
    }

}

