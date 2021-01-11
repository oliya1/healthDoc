package com.nicico.healthDoc.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loc_id")
    private Long id;

    @Column(name = "loc_name")
    private String name;

//    @Column(name = "date_created")
//    @CreationTimestamp
//    private Date dateCreated;
//
//    @Column(name = "date_updated")
//    @UpdateTimestamp
//    private Date lastUpdate;
}
