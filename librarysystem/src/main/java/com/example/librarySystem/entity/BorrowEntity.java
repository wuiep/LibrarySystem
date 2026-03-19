package com.example.librarySystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "borrow_record")
public class BorrowEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrow_id")
    private Long borrowId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;


    @ManyToOne
    @JoinColumn(name = "inventory_id")
    private InventoryEntity inventory;

    @Column(name = "borrow_time", nullable = false, updatable = false)
    private LocalDateTime borrowTime;

    @Column(name = "return_time")
    private LocalDateTime returnTime;


}







