package com.kodlamaio.HRManageSystem.dataAccess.abstracts.resumeDaos;

import com.kodlamaio.HRManageSystem.entities.concreates.Employee;
import com.kodlamaio.HRManageSystem.entities.concreates.resume.Education;
import com.kodlamaio.HRManageSystem.entities.concreates.resume.Experience;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExperienceDao extends JpaRepository<Experience,Integer> {
    List<Experience> getByResume_ResumeId(int resumeId, Sort sort);
}
