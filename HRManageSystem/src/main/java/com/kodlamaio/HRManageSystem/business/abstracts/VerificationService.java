package com.kodlamaio.HRManageSystem.business.abstracts;

import com.kodlamaio.HRManageSystem.core.utilities.result.DataResult;
import com.kodlamaio.HRManageSystem.core.utilities.result.Result;
import com.kodlamaio.HRManageSystem.entities.abstracts.User;
import com.kodlamaio.HRManageSystem.entities.concreates.Personal;
import com.kodlamaio.HRManageSystem.entities.concreates.Verification;

import java.util.List;

public interface VerificationService {
    DataResult<List<Verification>> getAll();
    Result add(Verification verification);

}
