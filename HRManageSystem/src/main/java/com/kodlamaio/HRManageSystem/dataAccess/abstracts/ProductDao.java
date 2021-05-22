package com.kodlamaio.HRManageSystem.dataAccess.abstracts;

import com.kodlamaio.HRManageSystem.entities.concreates.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<JobPosition,Integer> {
}
