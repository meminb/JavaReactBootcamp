package com.kodlamaio.HRManageSystem.dataAccess.abstracts.resumeDaos;

import com.kodlamaio.HRManageSystem.entities.concreates.resume.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public  interface ResumeDao extends JpaRepository<Resume, Integer> {
 Resume getByResumeId(int resumeId);
 List<Resume> getByEmployee_UserId(int userId);
}
