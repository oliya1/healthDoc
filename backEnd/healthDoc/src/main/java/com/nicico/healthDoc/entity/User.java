package com.nicico.healthDoc.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name = "tbl_user")
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "user_name")
    private String userName;

//    @Column(name = "usr_loc_id")
    @ManyToOne
    @JoinColumn(name = "usr_loc_id")
    private Location location;

    @Column(name = "rule")
    private String rule;
}
