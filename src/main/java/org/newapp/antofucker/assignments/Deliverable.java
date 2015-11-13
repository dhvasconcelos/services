package org.newapp.antofucker.assignments;

import org.newapp.antofucker.othershits.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cadet on 12/11/15.
 */

public class Deliverable {
    private String title;
    private String url;
    private String userName;
    private Date deliveryDate;
    private Date assignDate;
    private Map<String, Tag> tags = new HashMap<>();
    private boolean approved = false;


    public Deliverable(String userName) {
        this.userName = userName;

    }

    public Deliverable (String userName, String title, Date deliveryDate, String url) {
        this.userName = userName;
        this.title = title;
        this.deliveryDate = deliveryDate;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public void addTag(Tag tag) {
        tags.put(tag.getTitle(), tag);
    }

    public void deleteTag(Tag tag) {
        tags.remove(tag.getTitle());
    }

    public boolean hasTag(Tag tag) {
        return tags.containsKey(tag.getTitle());
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Date getAssignDate() {
        return assignDate;
    }

    public void setAssignDate(Date assignDate) {
        this.assignDate = assignDate;
    }

    public Map<String, Tag> getTags() {
        return tags;
    }

    public void setTags(Map<String, Tag> tags) {
        this.tags = tags;
    }
}
