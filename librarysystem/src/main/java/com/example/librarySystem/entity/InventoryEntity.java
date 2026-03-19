package com.example.librarySystem.entity;

import com.example.librarySystem.enums.InventoryStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

/**
 * 庫存物件
 */
@Entity
@ToString
@Getter
@Setter
@Table(name = "inventory")
public class InventoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    private Long inventoryId;

    @ManyToOne
    @JoinColumn(name = "ISBN")
    private BookEntity book;

    @CreationTimestamp
    @Column(name = "store_time", nullable = false, updatable = false)
    private LocalDateTime storeTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private InventoryStatus status;

}
