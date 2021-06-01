package com.kodlamaio.HRManageSystem.business.abstracts;

import com.kodlamaio.HRManageSystem.core.utilities.result.DataResult;
import com.kodlamaio.HRManageSystem.core.utilities.result.Result;
import com.kodlamaio.HRManageSystem.entities.concreates.Employer;
import com.kodlamaio.HRManageSystem.entities.concreates.Personal;

import java.util.List;

public interface EmployerServices {
    DataResult<List<Employer>> getAll();
    Result add(Employer employer);
}
