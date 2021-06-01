package com.kodlamaio.HRManageSystem.business.abstracts;

import com.kodlamaio.HRManageSystem.core.utilities.result.DataResult;
import com.kodlamaio.HRManageSystem.core.utilities.result.Result;
import com.kodlamaio.HRManageSystem.entities.concreates.Personal;

import java.util.List;

public interface PersonalService {
    DataResult<List<Personal>> getAll();
    Result add(Personal personal);

}
