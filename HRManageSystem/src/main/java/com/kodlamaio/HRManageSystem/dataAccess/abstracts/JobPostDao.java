package com.kodlamaio.HRManageSystem.dataAccess.abstracts;

import com.kodlamaio.HRManageSystem.entities.concreates.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobPostDao extends JpaRepository<JobPost, Integer> {
     List<JobPost> getByActivity(boolean isActive);
     JobPost getByPostId(int id);
     List<JobPost> getByActivityAndEmployer_UserId(boolean activity,int userId);



}
