package com.kodlamaio.HRManageSystem.entities.concreates.resume;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "educations")
public class Education {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="education_id")
    private int educationID;



    @ManyToOne()
    @JsonBackReference
    @JoinColumn(name="resume_id")
    private Resume resume;

    @NotNull
    @Column(name="school_name")
    private String schoolName;

    @NotNull
    @Column(name="department_name")
    private String departmentName;

  //  @NotNull
  //  @Column(name="faculty_name")
   // private String facultyName;

    @NotNull
    @Column(name="start_date")
    private String startDate;


    @Column(name="end_date")
    private String endDate;


}
