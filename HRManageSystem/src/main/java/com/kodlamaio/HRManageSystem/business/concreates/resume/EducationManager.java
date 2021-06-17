package com.kodlamaio.HRManageSystem.business.concreates.resume;

import com.kodlamaio.HRManageSystem.business.abstracts.resume.EducationService;
import com.kodlamaio.HRManageSystem.business.abstracts.resume.ResumeService;
import com.kodlamaio.HRManageSystem.core.utilities.result.DataResult;
import com.kodlamaio.HRManageSystem.core.utilities.result.Result;
import com.kodlamaio.HRManageSystem.core.utilities.result.SuccessDataResult;
import com.kodlamaio.HRManageSystem.core.utilities.result.SuccessResult;
import com.kodlamaio.HRManageSystem.dataAccess.abstracts.resumeDaos.EducationDao;
import com.kodlamaio.HRManageSystem.dataAccess.abstracts.resumeDaos.ResumeDao;
import com.kodlamaio.HRManageSystem.entities.concreates.resume.Education;
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
public class EducationManager implements EducationService {

    EducationDao educationDao;
    ResumeDao resumeDao;

    @Autowired
    public EducationManager(EducationDao educationDao,ResumeDao resumeDao) {
        this.educationDao = educationDao;this.resumeDao=resumeDao;
    }



    @Override
    public DataResult<List<Education>> getByResumeIdSorted(int resumeId) {
        Sort sort=Sort.by(Sort.Direction.DESC,"endDate");
        return new SuccessDataResult<List<Education>>(this.educationDao.getByResume_ResumeId(resumeId,sort));
    }

    @Override
    public Result add(int resumeId,String schoolName,String departmentName,String startDate,String endDate) {
        Resume resume=resumeDao.getOne(resumeId);
        if(endDate==null){
            endDate="not graduated";// devam ediyor anlamında bunu kullandım çünkü karakter sıralamasında en büyük olacak
        }


        Education edu=new Education(0,resume,schoolName,departmentName,startDate,endDate);

        educationDao.save(edu);
        return new SuccessResult("Education saved");
    }
}
