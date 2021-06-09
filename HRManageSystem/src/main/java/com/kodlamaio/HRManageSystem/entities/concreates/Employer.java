package com.kodlamaio.HRManageSystem.entities.concreates;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "employers")
@AllArgsConstructor
@NoArgsConstructor
public class Employer extends User {

    @Column(name = "company")
    private String company;

    @Column(name = "web_site")
    private String webSite;

    @Column(name = "phone")
    private  String phone;


    @Column(name = "verificated_by")
    private int verifiedBy;


    @OneToMany(mappedBy = "employer")
    @JsonManagedReference
    private List<JobPost> posts;






}
