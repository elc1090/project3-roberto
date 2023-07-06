package com.roberto.greenhousing.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "plant")
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String tag;
    @ManyToOne
    private Species species;
    @Column
    private Integer wateringFrequency;
}
