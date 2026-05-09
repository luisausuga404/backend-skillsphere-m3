package com.grupo10.skillsphere.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "institutions")
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String country;
    private String website;
    private String type;

    @OneToMany(mappedBy = "institution")
    private List<Certificate> certificates;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(columnDefinition = "vector")
    private float[] embedding;
}
