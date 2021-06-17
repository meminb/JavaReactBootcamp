package com.kodlamaio.HRManageSystem.business.concreates.resume;

import com.kodlamaio.HRManageSystem.business.abstracts.resume.LanguageService;
import com.kodlamaio.HRManageSystem.core.utilities.result.*;
import com.kodlamaio.HRManageSystem.dataAccess.abstracts.resumeDaos.LanguageDao;
import com.kodlamaio.HRManageSystem.dataAccess.abstracts.resumeDaos.ResumeDao;
import com.kodlamaio.HRManageSystem.entities.concreates.resume.Language;
import com.kodlamaio.HRManageSystem.entities.concreates.resume.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Component@SpringBootApplication

public class LanguageManager implements LanguageService {

    LanguageDao languageDao;
    ResumeDao resumeDao;

    @Autowired
    public LanguageManager(LanguageDao languageDao,ResumeDao resumeDao){this.languageDao=languageDao;this.resumeDao=resumeDao;}

    @Override
    public DataResult<List<Language>> getByResumeId(int resumeId) {
        return new SuccessDataResult<List<Language>>( this.languageDao.getByResume_ResumeId(resumeId));
    }

    @Override
    public Result add(int resumeId, String language, int level) {

        if(level>5 ||level<1){
            return new ErrorResult(" Level must be between 1-5");
        }

        Resume resume=resumeDao.getByResumeId(resumeId);
        Language language1= new Language(0,resume,language,level);
        languageDao.save(language1);
        return new SuccessResult("Language inserted");
    }
}
