package com.kodlamaio.HRManageSystem.business.concreates;

import com.kodlamaio.HRManageSystem.business.abstracts.JobPositionService;
import com.kodlamaio.HRManageSystem.core.utilities.result.*;
import com.kodlamaio.HRManageSystem.core.validation.abstracts.JobPositionValidationService;
import com.kodlamaio.HRManageSystem.core.validation.concreate.JobPositionValidationManager;
import com.kodlamaio.HRManageSystem.dataAccess.abstracts.JobPositionDao;
import com.kodlamaio.HRManageSystem.entities.concreates.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Component
@Service
@SpringBootApplication
public class JobPositionManager implements JobPositionService {
    private JobPositionDao jobPositionDao;
    private JobPositionValidationService jobPositionValidationService;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        this.jobPositionValidationService=new JobPositionValidationManager(jobPositionDao);
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(),"Data Listed");
    }

    @Override
    public Result add(JobPosition jobPosition) {
        if(!jobPositionValidationService.isPositionUnique(jobPosition)){
            return new ErrorResult("Position already exist");
        }

        this.jobPositionDao.save(jobPosition);
        return new SuccessResult("Job Position added");

    }
}
