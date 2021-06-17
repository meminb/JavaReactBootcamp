package com.kodlamaio.HRManageSystem.entities.concreates.resume;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.kodlamaio.HRManageSystem.entities.concreates.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="resumes")
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="resume_id")
    private int resumeId;



    @ManyToOne()
    @JsonBackReference
    @JoinColumn(name="user_id")
    private Employee employee;

    @Column(name = "github")
    private String github;

    @Column(name = "linkedin")
    private String linkedin;

    @Column(name = "description")
    private String description;

    @Column(name = "creationDate")
    private String creationDate;

    @Column(name = "lastUpdate")
    private String lastUpdate;


    @OneToOne()@JsonBackReference
    @JoinColumn(name="image_id")
    private Image image;

    @OneToMany(mappedBy = "resume")
    @JsonManagedReference
    private List<Education> educations;

    @OneToMany(mappedBy = "resume")
    @JsonManagedReference
    private List<Language> languages;

    @OneToMany(mappedBy = "resume")
    @JsonManagedReference
    private List<Experience> experiences;

    @OneToMany(mappedBy = "resume")
    @JsonManagedReference
    private List<Technology> technologies;


}
