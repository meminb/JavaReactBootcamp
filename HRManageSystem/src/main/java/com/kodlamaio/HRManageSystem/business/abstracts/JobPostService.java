package com.kodlamaio.HRManageSystem.business.abstracts;

import com.kodlamaio.HRManageSystem.core.utilities.result.DataResult;
import com.kodlamaio.HRManageSystem.core.utilities.result.Result;
import com.kodlamaio.HRManageSystem.entities.concreates.JobPosition;
import com.kodlamaio.HRManageSystem.entities.concreates.JobPost;

import java.util.List;

public interface JobPostService {

    DataResult<List<JobPost>> getAll();

    DataResult<List<JobPost>> getAllSortedByDate();

    DataResult<List<JobPost>> getByActivity(boolean activity);
    DataResult<List<JobPost>> getByActivityAndEmployerID(boolean activity,int userId);


    Result add(String description,int maxSalary,int minSalary,String lastDay,int freePositions,int userId,int jobId,int cityId);

    DataResult<JobPost> updateActivity(int postId);

}
