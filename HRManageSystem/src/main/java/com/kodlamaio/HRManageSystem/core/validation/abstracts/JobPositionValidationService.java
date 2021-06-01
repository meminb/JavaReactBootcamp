package com.kodlamaio.HRManageSystem.core.validation.abstracts;

import com.kodlamaio.HRManageSystem.entities.concreates.JobPosition;

public interface JobPositionValidationService {

    boolean isPositionUnique(JobPosition jobPosition);
}
