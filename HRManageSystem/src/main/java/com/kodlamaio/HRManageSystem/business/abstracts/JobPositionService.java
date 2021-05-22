package com.kodlamaio.HRManageSystem.business.abstracts;

import com.kodlamaio.HRManageSystem.entities.concreates.JobPosition;

import java.util.List;

public interface JobPositionService {
    List<JobPosition> getAll();
}
