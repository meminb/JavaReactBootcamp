package com.kodlamaio.HRManageSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kodlamaio.HRManageSystem.entities.concreates.User;
public interface UserDao extends JpaRepository<User,Integer> {
}
