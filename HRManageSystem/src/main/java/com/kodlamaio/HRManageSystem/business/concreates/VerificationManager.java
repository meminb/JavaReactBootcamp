package com.kodlamaio.HRManageSystem.business.concreates;

import com.kodlamaio.HRManageSystem.business.abstracts.VerificationService;
import com.kodlamaio.HRManageSystem.core.utilities.result.DataResult;
import com.kodlamaio.HRManageSystem.core.utilities.result.Result;
import com.kodlamaio.HRManageSystem.core.utilities.result.SuccessDataResult;
import com.kodlamaio.HRManageSystem.core.utilities.result.SuccessResult;
import com.kodlamaio.HRManageSystem.dataAccess.abstracts.PersonalDao;
import com.kodlamaio.HRManageSystem.dataAccess.abstracts.VerificationDao;
import com.kodlamaio.HRManageSystem.entities.concreates.Personal;
import com.kodlamaio.HRManageSystem.entities.concreates.Verification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
@SpringBootApplication
public class VerificationManager implements VerificationService {


    VerificationDao verificationDao;

    @Autowired
    public VerificationManager(VerificationDao verificationDao){
        this.verificationDao=verificationDao;
    }



    @Override
    public DataResult<List<Verification>> getAll() {
        return new SuccessDataResult<List<Personal>>(this.verificationDao.findAll(),"Verifications Listed");
    }

    @Override
    public Result add(Verification verification) {
        this.verificationDao.save(verification);
        return new SuccessResult(verification.getVerificationType()+" Verified");
    }
}
