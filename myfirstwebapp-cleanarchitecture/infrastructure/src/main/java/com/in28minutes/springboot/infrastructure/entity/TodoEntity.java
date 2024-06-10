package com.in28minutes.springboot.infrastructure.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "todos")
public class TodoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "todo_id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userEntityId;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "target_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate targetDate;
    
    @Column(name = "done", nullable = false)
    private Boolean done;


}
