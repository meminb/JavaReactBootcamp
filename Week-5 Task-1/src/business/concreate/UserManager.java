package business.concreate;

import business.abstracts.UserService;
import business.abstracts.Validator;
import core.absracts.VerificationService;
import core.concreate.GoogleAdapter;
import core.concreate.VerificationManager;
import dataAccess.abstracts.UserDao;
import entities.concreate.User;

import java.util.List;

public class UserManager implements UserService {

    private Validator validator;
    private UserDao userDao;
    private VerificationService verificationService;

    public UserManager(Validator validateManager, UserDao userDao, VerificationService verificationManager) {
        this.verificationService=verificationManager;
        this.validator = validateManager;
        this.userDao=userDao;
    }

    public void verify (User user){
        verificationService.verify(user);
    }
    @Override
    public void signUp(User user) {
        if(validator.isEMailValid(user)&&
                validator.isNameValid(user)&&
                validator.isSurnameValid(user)&&
                validator.isPasswordValid(user)){
            userDao.add(user);
            System.out.println(user.getE_mail() +"Signed up!");
            verificationService.sendVerificationEmail(user);

        }
    }

    @Override
    public void deleteUser(User user) {
        try{
            userDao.delete(user);
            System.out.println(user.getE_mail()+" deleted!");
        }catch (Exception e){

        }
    }

    @Override
    public User getByEmail(String email) {
        return userDao.getByEmail(email);

    }

    @Override
    public void login(String email, String password) {
        try{
            if(userDao.getByEmail(email).getPassword().equals(password)){
                System.out.println("  "+email+" Signed In!");
            }
        }catch (Exception e){
            System.out.println(" Email or password is wrong");
        }


    }

    @Override
    public List<User> getlAll() {
        return userDao.getAll();
    }





}
