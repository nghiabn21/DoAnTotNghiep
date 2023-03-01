package com.webthymeleaf.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "RightOnDevice")
@Table(name = "right_on_device")
public class RightOnDevice {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")

    private String id;


    @Column(name = "user_node_id", nullable = false)
    private String userNodeId;

    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST,
            CascadeType.REFRESH }, targetEntity = UserNode.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_node_id", insertable = false, updatable = false, referencedColumnName = "id")
    private UserNode node;


    @Column(name = "device_id", nullable = false)
    private String deviceId;

    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST,
            CascadeType.REFRESH }, targetEntity = Device.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "device_id", insertable = false, updatable = false, referencedColumnName = "id")
    private Device device;

}