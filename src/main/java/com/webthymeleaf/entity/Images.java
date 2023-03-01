//package com.webthymeleaf.entity;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.util.List;
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Table(name = "images")
//@Entity
//public class Images {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id ;
//
//    @Column(name = "name")
//    private String name ;
//
//    @Column(name = "high")
//    private String high ;
//    @ManyToOne
//    @JoinColumn(name = "chanel_id")
//    private User user;
//}
