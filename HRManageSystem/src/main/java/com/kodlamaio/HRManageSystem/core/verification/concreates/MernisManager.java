package com.kodlamaio.HRManageSystem.core.verification.concreates;

import com.kodlamaio.HRManageSystem.core.verification.abstracts.MernisService;
import com.kodlamaio.HRManageSystem.entities.concreates.Employee;
public class MernisManager implements MernisService {
    @Override
    public boolean checkIfRealPerson(Employee employee) {
        return employee.getIdNumber().length() == 11;
    }
}
