package com.kodlamaio.HRManageSystem.core.validation.concreate;

import com.kodlamaio.HRManageSystem.core.validation.abstracts.EmployerValidationService;
import com.kodlamaio.HRManageSystem.dataAccess.abstracts.EmployerDao;
import com.kodlamaio.HRManageSystem.dataAccess.abstracts.UserDao;
import com.kodlamaio.HRManageSystem.entities.concreates.Employee;
import com.kodlamaio.HRManageSystem.entities.concreates.Employer;
import com.kodlamaio.HRManageSystem.entities.concreates.Personal;
import com.kodlamaio.HRManageSystem.entities.concreates.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployerValidationManager implements EmployerValidationService {



    UserDao userDao;
    EmployerDao employerDao;



    @Autowired
    public EmployerValidationManager(UserDao userDao, EmployerDao employerDao) {
        this.userDao = userDao;
        this.employerDao = employerDao;
    }

    @Override
    public boolean isAllFieldFilled(Employer employer) {
        return employer.getEmail()!= null && employer.getCompany()!=null && employer.getPassword()!=null&&
                employer.getWebSite()!=null;
    }

    @Override
    public boolean isEmailUnique(String email) {
        List<User> allUsers= userDao.findAll();
        for (User e: allUsers) {
            if(e.getEmail().equals(email)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean validateByPersonal(Employer employer, Personal personal) {
        return false;
    }

    @Override
    public boolean isValidatedByPersonal(Employer employer) {
        return employer.getVerifiedBy()>0;
    }


}
