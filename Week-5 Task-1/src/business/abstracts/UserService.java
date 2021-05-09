package business.abstracts;

import entities.concreate.User;

import java.util.List;

public interface UserService {

    void signUp(User user);
    void deleteUser(User user);
    User getByEmail(String email);
    void login(String email, String password);
    List<User> getlAll();


}
