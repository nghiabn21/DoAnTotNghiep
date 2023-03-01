package com.webthymeleaf.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "environment")
public class Environment {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id")
    private String id;


//    @Column(name = "node_id", nullable = false)
//    private String nodeId;
//
    @Column(name = "time")
    private Timestamp time;

    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST,
            CascadeType.REFRESH }, targetEntity = Node.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "node_id", insertable = false, updatable = false, referencedColumnName = "id")
    private Node node;


    @Column(name = "environment_data", nullable = false)
    private String environmentData;

//
//    @Column(name = "time", nullable = false)
//    private Date time;
}