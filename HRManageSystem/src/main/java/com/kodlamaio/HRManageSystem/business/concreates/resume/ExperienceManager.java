package com.kodlamaio.HRManageSystem.business.concreates.resume;

import com.kodlamaio.HRManageSystem.business.abstracts.resume.ExperienceService;
import com.kodlamaio.HRManageSystem.core.utilities.result.DataResult;
import com.kodlamaio.HRManageSystem.core.utilities.result.Result;
import com.kodlamaio.HRManageSystem.core.utilities.result.SuccessDataResult;
import com.kodlamaio.HRManageSystem.core.utilities.result.SuccessResult;
import com.kodlamaio.HRManageSystem.dataAccess.abstracts.resumeDaos.EducationDao;
import com.kodlamaio.HRManageSystem.dataAccess.abstracts.resumeDaos.ExperienceDao;
import com.kodlamaio.HRManageSystem.dataAccess.abstracts.resumeDaos.ResumeDao;
import com.kodlamaio.HRManageSystem.entities.concreates.resume.Education;
import com.kodlamaio.HRManageSystem.entities.concreates.resume.Experience;
import com.kodlamaio.HRManageSystem.entities.concreates.resume.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Component
@Service
@SpringBootApplication
public class ExperienceManager implements ExperienceService {

    ExperienceDao experienceDao;
    ResumeDao resumeDao;

    @Autowired
    public ExperienceManager(ExperienceDao experienceDao,ResumeDao resumeDao) {
        this.experienceDao = experienceDao;this.resumeDao=resumeDao;
    }




    @Override
    public DataResult<List<Experience>> getByResumeIdSorted(int resumeId) {
        Sort sort=Sort.by(Sort.Direction.DESC,"endDate");
        return new SuccessDataResult<List<Experience>>(this.experienceDao.getByResume_ResumeId(resumeId,sort));
    }

    @Override
    public Result add(int resumeId, String companyName, String positionName, String startDate, String endDate) {
        Resume resume=resumeDao.getOne(resumeId);
        if(endDate==null){
            endDate="still working";// devam ediyor anlamında bunu kullandım çünkü karakter sıralamasında en büyük olacak
        }


        Experience experience=new Experience(0,resume,startDate,endDate,companyName,positionName);

        experienceDao.save(experience);
        return new SuccessResult("Education saved");
    }
}
