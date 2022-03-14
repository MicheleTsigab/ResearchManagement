package io.research.database;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Proposal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    String status; //accepted, rejected, waiting or disapproved

    @ManyToOne(cascade = CascadeType.ALL)
    ProposalCall call;

    @ManyToOne(cascade = CascadeType.ALL)
    Staff researcher;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "proposal_id")
    List<Version> version = new ArrayList<>(); // proposals will have many version.

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "proposal_id")
    List<Milestone> milestones = new ArrayList<>(); // proposals will have many milestones.

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ProposalCall getCall() {
        return call;
    }

    public void setCall(ProposalCall call) {
        this.call = call;
    }

    public Staff getResearcher() {
        return researcher;
    }

    public void setResearcher(Staff researcher) {
        this.researcher = researcher;
    }

    public List<Version> getVersion() {
        return version;
    }

    public void setVersion(List<Version> version) {
        this.version = version;
    }

    public List<Milestone> getMilestones() {
        return milestones;
    }

    public void setMilestones(List<Milestone> milestones) {
        this.milestones = milestones;
    }
}
