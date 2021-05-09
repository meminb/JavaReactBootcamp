package dataAccess.abstracts;

import entities.concreate.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    void delete(User user);
    List<User> getAll();
    User getByEmail(String email);


}
