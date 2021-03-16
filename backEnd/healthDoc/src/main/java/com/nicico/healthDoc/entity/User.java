package com.nicico.healthDoc.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name = "tbl_user")
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbl_user_seq")
    @SequenceGenerator(name = "tbl_user_seq", sequenceName = "tbl_user_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "user_name", unique = true)
    private String userName;

//    @Column(name = "usr_loc_id")
    @ManyToOne
    @JoinColumn(name = "usr_loc_id", nullable = false)
    private Location location;

    @Column(name = "rule")
    private String rule;

    @Column(name = "hidean")
    private int hidean;

    @Column(name = "version")
    private int version;

    @ManyToOne
    @JoinColumn(name = "create_by")
    private User createBy;
}
