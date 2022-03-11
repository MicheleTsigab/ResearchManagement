package io.swagger.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class ProposalCall {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    String title;
    String Topic;
    String file;
    LocalDate date;
    LocalDate deadline;
}
