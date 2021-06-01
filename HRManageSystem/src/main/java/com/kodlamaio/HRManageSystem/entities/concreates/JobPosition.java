package com.kodlamaio.HRManageSystem.entities.concreates;

import com.kodlamaio.HRManageSystem.entities.abstracts.Entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@Entity
@Table(name ="jobpositions")
@AllArgsConstructor
@NoArgsConstructor
public class JobPosition implements Entities {
    @Id
    @GeneratedValue
    @Column(name = "job_id")
    private int id;


    @Column(name = "job_name")
    private String jobName;


}
