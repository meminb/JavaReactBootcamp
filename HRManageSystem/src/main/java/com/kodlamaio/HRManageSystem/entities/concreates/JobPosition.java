package com.kodlamaio.HRManageSystem.entities.concreates;

import com.kodlamaio.HRManageSystem.entities.abstracts.Entities;

import javax.persistence.*;

@Entity
@Table(name ="jobpositions")
public class JobPosition implements Entities {
    @Id
    @GeneratedValue
    @Column(name = "job_id")
    private int id;


    @Column(name = "job_name")
    private String productName;

    public JobPosition(){}
    public JobPosition(int id, String productName) {
        this.id = id;
        this.productName = productName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
