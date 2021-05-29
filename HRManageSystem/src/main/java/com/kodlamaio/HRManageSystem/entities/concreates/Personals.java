package com.kodlamaio.HRManageSystem.entities.concreates;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.exception.DataException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "personals")
@AllArgsConstructor
@NoArgsConstructor
public class Personals extends Users{


    @Column(name = "startdate")
    private Date startDate;

    @Column(name = "job_id")
    private int jobId;

}
