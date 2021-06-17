package com.kodlamaio.HRManageSystem.dataAccess.abstracts;

import com.kodlamaio.HRManageSystem.entities.concreates.Employee;
import com.kodlamaio.HRManageSystem.entities.concreates.Personal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee,Integer> {

    Employee getByUserId(int userId);
}
