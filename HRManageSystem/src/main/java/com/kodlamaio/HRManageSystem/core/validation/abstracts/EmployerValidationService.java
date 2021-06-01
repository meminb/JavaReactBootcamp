package com.kodlamaio.HRManageSystem.core.validation.abstracts;

import com.kodlamaio.HRManageSystem.entities.concreates.Employee;
import com.kodlamaio.HRManageSystem.entities.concreates.Employer;
import com.kodlamaio.HRManageSystem.entities.concreates.Personal;

public interface EmployerValidationService {

    boolean isAllFieldFilled(Employer employer);

    boolean isEmailUnique(String email);

    boolean validateByPersonal(Employer employer, Personal personal);

    boolean isValidatedByPersonal(Employer employer);


}
