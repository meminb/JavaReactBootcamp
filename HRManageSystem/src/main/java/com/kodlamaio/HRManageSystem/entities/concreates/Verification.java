package com.kodlamaio.HRManageSystem.entities.concreates;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@Entity
@Table(name = "verification")
@AllArgsConstructor
@NoArgsConstructor
public class Verification {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "verification_id")
    private int verificationID;

    @Column(name = "verification_state")
    private String verificationState;

    @Column(name = "verification_type")
    private String verificationType;

    @Column(name = "verified_user")
    private int veriffiedUser;
}
