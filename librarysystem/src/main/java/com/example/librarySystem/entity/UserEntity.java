package com.example.librarySystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@ToString
@Getter
@Setter
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "username",nullable = false)
    String username;

    @Column(name = "password",nullable = false)
    String password;


    @Column(name = "phonenumber",nullable = false)
    String phoneNumber;


    @Column(name = "email",nullable = false)
    String email;

    @CreationTimestamp
    @Column(name = "registration_time", nullable = false, updatable = false)
    private LocalDateTime registrationTime;


    @Column(name = "last_login")
    private LocalDateTime lastLogin;


}
