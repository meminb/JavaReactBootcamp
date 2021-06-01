package com.kodlamaio.HRManageSystem.dataAccess.abstracts;

import com.kodlamaio.HRManageSystem.entities.concreates.Personal;
import com.kodlamaio.HRManageSystem.entities.concreates.Verification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationDao extends JpaRepository<Verification,Integer> {
}
