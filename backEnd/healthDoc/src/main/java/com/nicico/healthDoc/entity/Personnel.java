package com.nicico.healthDoc.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "sick")
public class Personnel {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sick_seq")
    @SequenceGenerator(name = "sick_seq", sequenceName = "sick_seq", allocationSize = 1)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "fname", nullable = false)
    private String fname;

    @Column(name = "lname")
    private String lname;

    @Column(name = "personnel_no", nullable = false, unique = true)
    private Long personnelNo;

    @Column(name = "national_code")
    private String nationalCode;

    @ManyToOne
    @JoinColumn(name = "create_by")
    private User createBy;
}
