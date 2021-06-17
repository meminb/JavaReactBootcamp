package com.kodlamaio.HRManageSystem.dataAccess.abstracts.resumeDaos;

import com.kodlamaio.HRManageSystem.entities.concreates.Employee;
import com.kodlamaio.HRManageSystem.entities.concreates.resume.Education;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationDao extends JpaRepository<Education,Integer> {
    List<Education> getByResume_ResumeId(int resumeId, Sort sort);

}
