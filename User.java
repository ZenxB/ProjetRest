package com.efrei.webservice_spring_efrei.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_Id", updatable = false, nullable = false)
    private int userId;

    @Column(name = "username",nullable=false)
    private String username;

    @Column(name = "user_Password",nullable=false)
    private String password;



}
