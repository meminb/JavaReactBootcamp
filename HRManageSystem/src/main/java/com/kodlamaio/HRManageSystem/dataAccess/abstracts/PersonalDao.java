package com.kodlamaio.HRManageSystem.dataAccess.abstracts;

import com.kodlamaio.HRManageSystem.entities.concreates.Personal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalDao extends JpaRepository<Personal,Integer> {



}
