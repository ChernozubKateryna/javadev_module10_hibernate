package com.goit.feature.planet;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "planet")
@Entity
@Data
public class Planet {
    @Id
    private String id;

    @Column(nullable = false, length = 200)
    private String name;
}
