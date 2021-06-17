package com.kodlamaio.HRManageSystem.dataAccess.abstracts.resumeDaos;

import com.kodlamaio.HRManageSystem.entities.concreates.Employee;
import com.kodlamaio.HRManageSystem.entities.concreates.resume.Image;
import com.kodlamaio.HRManageSystem.entities.concreates.resume.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageDao extends JpaRepository<Image,Integer> {
    Image getByResume_ResumeId(int resumeId);
}
