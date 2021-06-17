package com.kodlamaio.HRManageSystem.business.concreates.resume;

import com.kodlamaio.HRManageSystem.business.abstracts.resume.ResumeService;
import com.kodlamaio.HRManageSystem.core.utilities.result.DataResult;
import com.kodlamaio.HRManageSystem.core.utilities.result.Result;
import com.kodlamaio.HRManageSystem.core.utilities.result.SuccessDataResult;
import com.kodlamaio.HRManageSystem.core.utilities.result.SuccessResult;
import com.kodlamaio.HRManageSystem.dataAccess.abstracts.EmployeeDao;
import com.kodlamaio.HRManageSystem.dataAccess.abstracts.resumeDaos.ResumeDao;
import com.kodlamaio.HRManageSystem.entities.concreates.Employee;
import com.kodlamaio.HRManageSystem.entities.concreates.resume.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Component
@Service
@SpringBootApplication
public class ResumeManager implements ResumeService {

    ResumeDao resumeDao;
    EmployeeDao employeeDao;

    @Autowired
    public ResumeManager(ResumeDao resumeDao,EmployeeDao employeeDao) {
        this.resumeDao = resumeDao;this.employeeDao=employeeDao;
    }

    @Override
    public DataResult<List<Resume>> getAll() {
        return new  SuccessDataResult<List<Resume>>(this.resumeDao.findAll(),"All Resumes listed");
    }

    @Override
    public Result add(String github,String linkedin,String description,int userID) {
        Employee emp= employeeDao.getByUserId(userID);
        Date date = new Date();
        String creationDate= new Timestamp(date.getTime()).toString();

        Resume resume=new Resume();
        resume.setEmployee(emp);
        resume.setDescription(description);
        resume.setGithub(github);
        resume.setCreationDate(creationDate);
        resume.setLinkedin(linkedin);
        resume.setLastUpdate(creationDate);



        resumeDao.save(resume);
        return new SuccessResult("Resume inserted");
    }

    @Override
    public DataResult<List<Resume>> getByUserId(int userId) {
        return new SuccessDataResult<List<Resume>>(this.resumeDao.getByEmployee_UserId(userId),"Resumes listed for user who have user id"+userId);
    }
}
