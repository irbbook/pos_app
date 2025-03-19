package com.example.adapter.entity;

import com.example.util.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "POS_TBL_USER")
public class PosTblUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")  // Upper snake case column name
    private Long id;

    @Column(name = "USERNAME", nullable = false, unique = true)
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE", nullable = false)
    private Role role; // Enum: ADMIN, CASHIER, STOCK_MANAGER

    @Column(name = "IS_ACTIVE", nullable = false)
    private Boolean isActive = true;

    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "CREATED_BY", nullable = false, updatable = false)
    private String createdBy;

    @Column(name = "UPDATED_AT")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column(name = "UPDATED_BY")
    private String updatedBy;
}

