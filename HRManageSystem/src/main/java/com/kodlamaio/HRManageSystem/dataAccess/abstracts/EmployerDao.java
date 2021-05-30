package com.kodlamaio.HRManageSystem.dataAccess.abstracts;

import com.kodlamaio.HRManageSystem.entities.concreates.Employer;
import com.kodlamaio.HRManageSystem.entities.concreates.Personal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerDao extends JpaRepository<Employer,Integer> {
}
