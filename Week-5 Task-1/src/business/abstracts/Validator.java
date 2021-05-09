package business.abstracts;

import entities.concreate.User;

public interface Validator {
    boolean isEMailValid(User user);
    boolean isNameValid(User user);
    boolean isSurnameValid(User user);
    boolean isPasswordValid(User user);



}
