package com.grupo10.skillsphere.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "certificates")
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private LocalDate issueDate;
    private LocalDate expiryDate;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "institution_id")
    private Institution institution;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(columnDefinition = "vector")
    private float[] embedding;
}
