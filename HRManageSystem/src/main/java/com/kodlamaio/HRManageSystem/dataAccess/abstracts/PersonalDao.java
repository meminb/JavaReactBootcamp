package com.kodlamaio.HRManageSystem.dataAccess.abstracts;

import com.kodlamaio.HRManageSystem.entities.concreates.Personals;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalDao extends JpaRepository<Personals,Integer> {
}
