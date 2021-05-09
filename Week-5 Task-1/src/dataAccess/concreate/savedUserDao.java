package dataAccess.concreate;

import dataAccess.abstracts.UserDao;
import entities.concreate.User;

import java.util.ArrayList;
import java.util.List;

public class savedUserDao implements UserDao {

    private List<User> users;

    public savedUserDao() {
        this.users = new ArrayList<>();
    }




    @Override
    public void add(User user) {
        users.add(user);
    }

    @Override
    public void delete(User user) {
        users.remove(user);
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public User getByEmail(String email) {
        for (User u:
                users ) {
            if(u.getE_mail().equals(email)){
                return u;
            }

        }return null;
    }
}
