package com.kodlamaio.HRManageSystem.business.abstracts.resume;

import com.kodlamaio.HRManageSystem.core.utilities.result.DataResult;
import com.kodlamaio.HRManageSystem.core.utilities.result.Result;
import com.kodlamaio.HRManageSystem.entities.concreates.resume.Experience;
import com.kodlamaio.HRManageSystem.entities.concreates.resume.Technology;

import java.util.List;

public interface TechnologyService {
    DataResult<List<Technology>> getByResumeId(int resumeId);
    Result add(int resumeId, String techName);
}
