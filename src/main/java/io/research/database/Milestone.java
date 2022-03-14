package io.research.database;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Milestone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;
    double budget;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "milestone_id")
    List<Activity> activities = new ArrayList<>();
    boolean approved;
    boolean done;

    public Milestone() {
    }

    public Milestone(String name, double budget, List<Activity> activities, boolean approved, boolean done) {
        this.name = name;
        this.budget = budget;
        this.activities = activities;
        this.approved = approved;
        this.done = done;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
