package core.absracts;

import entities.concreate.User;

public interface VerificationService {
    void sendVerificationEmail(User user);
    void verify(User user);

}
