package com.kodlamaio.HRManageSystem.business.concreates;

import com.kodlamaio.HRManageSystem.business.abstracts.JobPostService;
import com.kodlamaio.HRManageSystem.core.utilities.result.*;
import com.kodlamaio.HRManageSystem.dataAccess.abstracts.CityDao;
import com.kodlamaio.HRManageSystem.dataAccess.abstracts.EmployerDao;
import com.kodlamaio.HRManageSystem.dataAccess.abstracts.JobPositionDao;
import com.kodlamaio.HRManageSystem.dataAccess.abstracts.JobPostDao;
import com.kodlamaio.HRManageSystem.entities.concreates.City;
import com.kodlamaio.HRManageSystem.entities.concreates.Employer;
import com.kodlamaio.HRManageSystem.entities.concreates.JobPosition;
import com.kodlamaio.HRManageSystem.entities.concreates.JobPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
@Component
@Service
@SpringBootApplication
public class JobPostManager implements JobPostService {



    private JobPostDao jobPostDao;
    private JobPositionDao jobPositionDao;
    private EmployerDao employerDao;
    private CityDao cityDao;
    @Autowired
    public JobPostManager(JobPostDao jobPostDao, JobPositionDao jobPositionDao, EmployerDao employerDao, CityDao cityDao) {
        this.jobPostDao = jobPostDao;
        this.jobPositionDao = jobPositionDao;
        this.employerDao = employerDao;
        this.cityDao = cityDao;
    }


    @Override
    public DataResult<List<JobPost>> getAll() {

        return new SuccessDataResult<List<JobPost>>(this.jobPostDao.findAll());
    }

    @Override
    public DataResult<List<JobPost>> getAllSortedByDate() {
        Sort sort=Sort.by(Sort.Direction.DESC,"postDate");

        return new SuccessDataResult<List<JobPost>>(this.jobPostDao.findAll(sort),"Job post sorted by date");
    }

    @Override
    public DataResult<List<JobPost>> getByActivity(boolean activity) {
        return new SuccessDataResult<List<JobPost>>(this.jobPostDao.getByActivity(activity));
    }

    @Override
    public DataResult<List<JobPost>> getByActivityAndEmployerID(boolean activity, int userId) {
        return new SuccessDataResult<List<JobPost>>(this.jobPostDao.getByActivityAndEmployer_UserId(activity,userId));
    }


    /**/
    @Override
    public Result add(String description,int maxSalary,int minSalary,String lastDay,int freePositions,int userId,int jobId,int cityId) {

        City city= cityDao.getByCityId(cityId);
        JobPosition job=jobPositionDao.getById(jobId);
        Employer employer=employerDao.getByUserId(userId);

        if (city==null){
            return new ErrorResult("Undefined city id");
        }else  if (description==null){
            return new ErrorResult("Description field cannot be null");
        }else if (job==null){
            return new ErrorResult("Position could not found");
        }else if (maxSalary< minSalary){
            return new ErrorResult("Max salary must be greater than mi salary");
        }else if (freePositions<1){
            return new ErrorResult("Free position must be greater than 0");
        }else if (lastDay==null){
            return new ErrorResult("Last day field cannot be null");
        }else if (employer==null){
            return new ErrorResult("Employer field cannot be null");
        }

        Date date = new Date();
        String postDate= new Timestamp(date.getTime()).toString();

            JobPost jobPost=new JobPost(0,description,maxSalary,minSalary,postDate,lastDay,true,freePositions,employer,job,city);
        System.out.println("asd  " +jobPost.getJobPosition().getJobName()+" "+jobPost.getEmployer().getCompany());
        jobPostDao.save(jobPost);
        return new SuccessResult("Job Post shared");

    }

    @Override
    public DataResult<JobPost> updateActivity(int postId) {
        JobPost post=jobPostDao.getByPostId(postId);
        if(post==null){
            return new ErrorDataResult<JobPost>("There is no post with given id!");
        }
        post.setActivity(!post.isActivity());

        jobPostDao.save(post);

        return new SuccessDataResult<JobPost>(post,"Post activity updated");
    }
}
