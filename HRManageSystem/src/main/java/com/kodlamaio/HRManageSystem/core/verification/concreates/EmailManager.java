package com.kodlamaio.HRManageSystem.core.verification.concreates;

import com.kodlamaio.HRManageSystem.core.verification.abstracts.EmailService;
import com.kodlamaio.HRManageSystem.entities.concreates.Employer;

public class EmailManager implements EmailService {
    @Override
    public boolean verify(Employer user) {
        //
        return true;
    }

    @Override
    public void sendMail(String email, String message) {
        System.out.println(message+" sent to " +email);
    }
}
