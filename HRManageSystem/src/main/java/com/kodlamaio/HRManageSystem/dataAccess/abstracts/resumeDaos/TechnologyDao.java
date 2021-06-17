package com.kodlamaio.HRManageSystem.dataAccess.abstracts.resumeDaos;

import com.kodlamaio.HRManageSystem.entities.concreates.Employee;
import com.kodlamaio.HRManageSystem.entities.concreates.resume.Experience;
import com.kodlamaio.HRManageSystem.entities.concreates.resume.Technology;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TechnologyDao extends JpaRepository<Technology,Integer> {
    List<Technology> getByResume_ResumeId(int resumeId);

}
