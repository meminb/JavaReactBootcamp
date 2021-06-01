package com.kodlamaio.HRManageSystem.core.verification.abstracts;

import com.kodlamaio.HRManageSystem.entities.concreates.Employer;

public interface EmailService {


    boolean verify(Employer user);

    void sendMail(String email,String message);
}
