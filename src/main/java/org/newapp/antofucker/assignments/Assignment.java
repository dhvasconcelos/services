package org.newapp.antofucker.assignments;

import org.newapp.antofucker.othershits.Bootcamp;

import java.sql.Date;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cadet on 12/11/15.
 */
public class Assignment {

    final private int bootcampID = Bootcamp.getInstance().getBootcampID();
    final private int assignmentID;

    private String assignmentType;
    private static int mockID = 0;
    private Date creationDate;
    private String title;
    private Map<String, Deliverable> deliverables = new HashMap<>();

    public Assignment(String title, String assignmentType) {
        //DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date myDate = new Date(System.currentTimeMillis());
        creationDate = new Date(myDate.getTime());
        setTitle(title);
        this.assignmentType = assignmentType;

        //MOCK ID
        assignmentID = mockID++;
    }

    public Assignment(String title, String assignmentType, String username) {
        //DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date myDate = new Date(System.currentTimeMillis());
        creationDate = new Date(myDate.getTime());
        setTitle(title);
        this.assignmentType = assignmentType;
        addDeliverable(new Deliverable(username));

        //MOCK ID
        assignmentID = mockID++;
    }

    public Assignment (Date creationDate, String title, int assignmentID, String assignmentType) {
        this.creationDate = creationDate;
        this.title = title;
        this.assignmentID = assignmentID;
        this.assignmentType = assignmentType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getBootcamp() {
        return bootcampID;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void addDeliverable(Deliverable deliverable) {
        deliverables.put(deliverable.getUserName(),deliverable);
    }

    public Collection<Deliverable> getDeliverables() {
        return deliverables.values();
    }

    public Deliverable getDeliverable(String userName) {
        return deliverables.get(userName);
    }

    public int getAssignmentID() {
        return assignmentID;
    }

    public String getAssignmentType() {
        return assignmentType;
    }

    public void setAssignmentType(String assignmentType) {
        this.assignmentType = assignmentType;
    }
}

