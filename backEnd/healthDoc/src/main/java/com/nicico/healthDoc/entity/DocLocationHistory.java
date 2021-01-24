package com.nicico.healthDoc.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "doc_location_history")
public class DocLocationHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "barcode")
    private String barcode;

    @Column(name = "date_time")
    @CreationTimestamp
    private LocalDateTime dateTime;

    @Column(name = "doc_level")
    private Integer level;

    @Column(name = "cycle")
    private Integer cycle;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User receiver;
}
