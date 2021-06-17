package com.kodlamaio.HRManageSystem.entities.concreates.resume;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="image_id")
    private int imageId;

    @Column(name="url")
    private String url;


    @OneToOne()@JsonBackReference
    @JoinColumn(name="resume_id")
    private Resume resume;


}
