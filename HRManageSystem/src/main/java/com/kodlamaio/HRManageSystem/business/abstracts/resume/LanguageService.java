package com.kodlamaio.HRManageSystem.business.abstracts.resume;

import com.kodlamaio.HRManageSystem.core.utilities.result.DataResult;
import com.kodlamaio.HRManageSystem.core.utilities.result.Result;
import com.kodlamaio.HRManageSystem.entities.concreates.resume.Language;
import com.kodlamaio.HRManageSystem.entities.concreates.resume.Technology;

import java.util.List;

public interface LanguageService {

    DataResult<List<Language>> getByResumeId(int resumeId);
    Result add(int resumeId, String language,int level);
}
