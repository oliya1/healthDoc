package com.nicico.healthDoc.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "reason_send")
public class ReasonSend {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reason_seq")
    @SequenceGenerator(name = "reason_seq", sequenceName = "reason_send_seq", allocationSize = 1)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "reason_name", nullable = false)
    private String name;

    @Column(name = "version")
    private int version;

    @ManyToOne
    @JoinColumn(name = "creator_id", nullable = false)
    private User creator;
}
