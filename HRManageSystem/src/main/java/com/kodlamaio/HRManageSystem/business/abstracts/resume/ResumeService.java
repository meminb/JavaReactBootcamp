package com.kodlamaio.HRManageSystem.business.abstracts.resume;

import com.kodlamaio.HRManageSystem.core.utilities.result.DataResult;
import com.kodlamaio.HRManageSystem.core.utilities.result.Result;
import com.kodlamaio.HRManageSystem.entities.concreates.Employee;
import com.kodlamaio.HRManageSystem.entities.concreates.resume.Resume;

import java.util.List;

public interface ResumeService {
    DataResult<List<Resume>> getAll();
    Result add(String github,String linkedin,String description,int userID);
    DataResult<List<Resume>>   getByUserId(int userId);
}
