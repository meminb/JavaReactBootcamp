package com.kodlamaio.HRManageSystem.business.abstracts;

import com.kodlamaio.HRManageSystem.core.utilities.result.DataResult;
import com.kodlamaio.HRManageSystem.core.utilities.result.Result;
import com.kodlamaio.HRManageSystem.entities.concreates.JobPosition;

import java.util.List;

public interface JobPositionService {
    DataResult<List<JobPosition>>getAll();
    Result add(JobPosition jobPosition);
}
