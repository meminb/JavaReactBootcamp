package com.kodlamaio.HRManageSystem.entities.concreates;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@Entity
@Table(name = "job_posts")
@AllArgsConstructor
@NoArgsConstructor
public class JobPost {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "post_id")
    private  int postId;

    @Column(name = "description")
    private String description;

    @Column(name = "max_salary")
    private int maxSalary;

    @Column(name = "min_salary")
    private int minSalary;

    @Column(name = "post_date")
    private String postDate;

    @Column(name = "last_day")
    private String lastDay;

    @Column(name = "is_active")
    private boolean activity;

    @Column(name = "free_positions")
    private int freePositions;

    @ManyToOne()
    @JoinColumn(name="company_id")
    @JsonBackReference
    private Employer employer;

    @ManyToOne()
    @JoinColumn(name="job_position_id")
    @JsonBackReference
    private JobPosition jobPosition;

    @ManyToOne()
    @JoinColumn(name="city_id")
    @JsonBackReference                          //used for recursive problem
    private City city;



}
