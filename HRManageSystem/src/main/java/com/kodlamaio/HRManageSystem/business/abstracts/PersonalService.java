package com.kodlamaio.HRManageSystem.business.abstracts;

import com.kodlamaio.HRManageSystem.core.utilities.result.DataResult;
import com.kodlamaio.HRManageSystem.core.utilities.result.Result;
import com.kodlamaio.HRManageSystem.entities.concreates.JobPosition;
import com.kodlamaio.HRManageSystem.entities.concreates.Personals;

import java.util.List;

public interface PersonalService {
    DataResult<List<Personals>> getAll();
    Result add(Personals personal);

}
