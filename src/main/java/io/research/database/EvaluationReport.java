package io.research.database;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class EvaluationReport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @OneToMany
    Set<Staff> evaluators =  new HashSet<>();

    @OneToOne(optional = false)
    Proposal proposal;

    @OneToMany(cascade = CascadeType.ALL)
    Set<Point> points = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    Set<Review> reviews = new HashSet<>();

    String[] papers;

    public String[] getPapers() {
        return papers;
    }

    public void setPapers(String[] papers) {
        this.papers = papers;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Staff> getEvaluators() {
        return evaluators;
    }

    public void setEvaluators(Set<Staff> evaluators) {
        this.evaluators = evaluators;
    }

    public Proposal getProposal() {
        return proposal;
    }

    public void setProposal(Proposal proposal) {
        this.proposal = proposal;
    }

    public Set<Point> getPoints() {
        return points;
    }

    public void setPoints(Set<Point> points) {
        this.points = points;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }
}
