package com.kodlamaio.HRManageSystem.entities.concreates.resume;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@Entity
@Table(name = "languages")
@AllArgsConstructor
@NoArgsConstructor
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="language_id")
    private int languageId;


    @ManyToOne()
    @JsonBackReference
    @JoinColumn(name="resume_id")
    private Resume resume;


    @Column(name="languageName")
    private String languageName;


    @Column(name = "level")
    private int level;






}
