package com.kodlamaio.HRManageSystem.dataAccess.abstracts.resumeDaos;

import com.kodlamaio.HRManageSystem.entities.concreates.Employee;
import com.kodlamaio.HRManageSystem.entities.concreates.resume.Language;
import com.kodlamaio.HRManageSystem.entities.concreates.resume.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LanguageDao extends JpaRepository<Language,Integer> {
    List<Language> getByResume_ResumeId(int resumeId);
}
