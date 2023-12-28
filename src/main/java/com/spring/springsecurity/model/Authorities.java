package com.spring.springsecurity.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "authorities")
public class Authorities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "authorities_name")
    private String authoritiesName;

    @ManyToMany(mappedBy = "authorities")
    private Set<User> users;



}
