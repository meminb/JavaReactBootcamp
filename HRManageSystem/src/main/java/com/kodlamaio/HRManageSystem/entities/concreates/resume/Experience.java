package com.kodlamaio.HRManageSystem.entities.concreates.resume;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@Entity
@Table(name = "experiences")
@AllArgsConstructor
@NoArgsConstructor
public class Experience {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="experience_id")
    private int experienceId;


    @ManyToOne()
    @JsonBackReference
    @JoinColumn(name="resume_id")
    private Resume resume;

    @NotNull
    @Column(name="start_date")
    private String startDate;


    @Column(name="end_date")
    private String endDate;


    @Column(name="company_name")
    private String companyName;


    @Column(name="position_name")
    private String positionName;


}
