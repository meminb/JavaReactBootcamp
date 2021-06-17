package com.kodlamaio.HRManageSystem.business.abstracts.resume;

import com.kodlamaio.HRManageSystem.core.utilities.result.DataResult;
import com.kodlamaio.HRManageSystem.core.utilities.result.Result;
import com.kodlamaio.HRManageSystem.entities.concreates.resume.Education;
import com.kodlamaio.HRManageSystem.entities.concreates.resume.Experience;

import java.util.List;

public interface ExperienceService {

    DataResult<List<Experience>> getByResumeIdSorted(int resumeId);

    Result add(int resumeId, String companyName, String positionName, String startDate, String endDate);

}
