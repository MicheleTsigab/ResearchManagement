package io.research.database;

import javax.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    Staff by;

    String content;

    String level; // level of the remark: Mandatory or Optional

    String Remark; // remark will be given by the author.

}
