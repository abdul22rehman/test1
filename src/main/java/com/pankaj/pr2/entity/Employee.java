package com.pankaj.pr2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "emailid", nullable = false, unique = true)
    private String emailid;

    @Column(name = "mobile", nullable = false, unique = true,length = 10)
    private String mobile;

}