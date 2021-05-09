package core.concreate;

import core.absracts.VerificationService;
import entities.concreate.User;

public class VerificationManager implements VerificationService {


    @Override
    public void sendVerificationEmail(User user) {
        System.out.println(" Click here to verify your account");
    }

    @Override
    public void verify(User user) {
        user.verifyUser();
        System.out.println("Your account has been verified!"
        );
    }
}
