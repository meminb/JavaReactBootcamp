package com.kodlamaio.HRManageSystem.core.validation.abstracts;

import com.kodlamaio.HRManageSystem.core.utilities.result.Result;
import com.kodlamaio.HRManageSystem.entities.concreates.Employee;

public interface EmployeeValidationService {


    boolean isAllFieldFilled(Employee employee);

    boolean isEmailUnique(String email);

    boolean isIdUnique(String id);

    boolean isMernisVerified(Employee employee);

}
