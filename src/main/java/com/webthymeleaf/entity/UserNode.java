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
@Entity(name = "UserNode")
@Table(name = "user_node")
public class UserNode {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

//    @Column(name = "users_id", nullable = false)
//    private String usersId;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id", insertable = false, updatable = false, referencedColumnName = "id")
    private User users;

//    @Column(name = "node_id", nullable = false)
//    private String nodeId;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Node.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "node_id", insertable = false, updatable = false, referencedColumnName = "id")
    private Node node;

    @Column(name = "rights", nullable = false)
    private String rights;
}