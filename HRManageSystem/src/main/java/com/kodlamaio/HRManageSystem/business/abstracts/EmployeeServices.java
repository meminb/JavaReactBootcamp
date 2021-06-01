package com.kodlamaio.HRManageSystem.business.abstracts;

import com.kodlamaio.HRManageSystem.core.utilities.result.DataResult;
import com.kodlamaio.HRManageSystem.core.utilities.result.Result;
import com.kodlamaio.HRManageSystem.entities.concreates.Employee;
import java.util.List;

public interface EmployeeServices {
    DataResult<List<Employee>> getAll();
    Result add(Employee employee);
}
