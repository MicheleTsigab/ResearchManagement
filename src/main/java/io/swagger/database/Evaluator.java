package io.swagger.database;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Evaluator {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    String level;
    @OneToMany(mappedBy = "staff")
    Collection<Staff> staffs = new ArrayList<>();


}
