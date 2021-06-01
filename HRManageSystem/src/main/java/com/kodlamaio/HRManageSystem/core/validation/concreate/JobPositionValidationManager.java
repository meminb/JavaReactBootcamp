package com.kodlamaio.HRManageSystem.core.validation.concreate;

import com.kodlamaio.HRManageSystem.core.validation.abstracts.JobPositionValidationService;
import com.kodlamaio.HRManageSystem.dataAccess.abstracts.JobPositionDao;
import com.kodlamaio.HRManageSystem.entities.concreates.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class JobPositionValidationManager implements JobPositionValidationService {


    JobPositionDao jobPositionDao;
    @Autowired
    public JobPositionValidationManager(JobPositionDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public boolean isPositionUnique(JobPosition jobPosition) {
        List<JobPosition> allPosition=jobPositionDao.findAll();

        for (JobPosition j: allPosition
             ) {
            if(j.getJobName().equals(jobPosition.getJobName())){
                return false;
            }

        }return true;




    }
}
