package com.kodlamaio.HRManageSystem.entities.concreates;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "personels")
@AllArgsConstructor
@NoArgsConstructor
public class Personal extends User {


    @Column(name = "startdate")
    private Date startDate;

    @Column(name = "job_id")
    private int jobId;

}
