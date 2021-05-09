package core.concreate;

import core.absracts.VerificationService;
import entities.concreate.User;
import google.abstracts.GoogleServices;

public class GoogleAdapter implements VerificationService {

    GoogleServices google;

    public GoogleAdapter(GoogleServices google) {
        this.google = google;
    }

    @Override
    public void sendVerificationEmail(User user) {
        if(google.authWithGoogle(user.getE_mail())){
            System.out.println(" Verification has sent to your google account");
        }

    }

    @Override
    public void verify(User user) {
        if(google.authWithGoogle(user.getE_mail())){
            System.out.println(" Your google account has been verified");
        }

    }
}
