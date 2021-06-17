package com.kodlamaio.HRManageSystem.business.abstracts.resume;

import com.kodlamaio.HRManageSystem.core.utilities.result.DataResult;
import com.kodlamaio.HRManageSystem.core.utilities.result.Result;
import com.kodlamaio.HRManageSystem.entities.concreates.City;
import com.kodlamaio.HRManageSystem.entities.concreates.resume.Education;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface EducationService {
    DataResult<List<Education>> getByResumeIdSorted(int resumeId);

    Result add(int resumeId,String schoolName,String departmentName,String startDate,String endDate);

}
