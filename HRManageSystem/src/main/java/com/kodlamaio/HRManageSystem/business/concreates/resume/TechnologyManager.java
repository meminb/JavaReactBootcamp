package com.kodlamaio.HRManageSystem.business.concreates.resume;

import com.kodlamaio.HRManageSystem.business.abstracts.resume.TechnologyService;
import com.kodlamaio.HRManageSystem.core.utilities.result.DataResult;
import com.kodlamaio.HRManageSystem.core.utilities.result.Result;
import com.kodlamaio.HRManageSystem.core.utilities.result.SuccessDataResult;
import com.kodlamaio.HRManageSystem.core.utilities.result.SuccessResult;
import com.kodlamaio.HRManageSystem.dataAccess.abstracts.resumeDaos.ResumeDao;
import com.kodlamaio.HRManageSystem.dataAccess.abstracts.resumeDaos.TechnologyDao;
import com.kodlamaio.HRManageSystem.entities.concreates.resume.Resume;
import com.kodlamaio.HRManageSystem.entities.concreates.resume.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Component
@SpringBootApplication
public class TechnologyManager implements TechnologyService {

    TechnologyDao technologyDao;
    ResumeDao resumeDao;

    @Autowired
    public  TechnologyManager(TechnologyDao technologyDao,ResumeDao resumeDao){
        this.technologyDao=technologyDao;this.resumeDao=resumeDao;
    }

    @Override
    public DataResult<List<Technology>> getByResumeId(int resumeId) {
        return  new SuccessDataResult<List<Technology>>(this.technologyDao.getByResume_ResumeId(resumeId));
    }

    @Override
    public Result add(int resumeId, String techName) {
        Resume resume= resumeDao.getOne(resumeId);
        Technology tech=new Technology(0,resume,techName);
        technologyDao.save(tech);

        return new SuccessResult(   "Technology inserted");
    }
}
