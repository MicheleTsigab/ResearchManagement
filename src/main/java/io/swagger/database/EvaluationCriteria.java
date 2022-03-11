package io.swagger.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EvaluationCriteria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    int weight;
    String name;
}
