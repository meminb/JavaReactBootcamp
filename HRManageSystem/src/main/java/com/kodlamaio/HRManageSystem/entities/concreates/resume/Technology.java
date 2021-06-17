package com.kodlamaio.HRManageSystem.entities.concreates.resume;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@Entity
@Table(name = "technologies")
@AllArgsConstructor
@NoArgsConstructor
public class Technology {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="technology_id")
    private int technologyId;


    @ManyToOne()
    @JsonBackReference
    @JoinColumn(name="resume_id")
    private Resume resume;



    @Column(name="technology_name")
    private String technologyName;

}
