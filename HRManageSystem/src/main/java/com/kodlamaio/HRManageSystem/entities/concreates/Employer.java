package com.kodlamaio.HRManageSystem.entities.concreates;


import com.kodlamaio.HRManageSystem.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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

    @Column(name = "email_ver_id")
    private int emailVerificationID;

    @Column(name = "verified_personal")
    private int verifiedBy;






}
