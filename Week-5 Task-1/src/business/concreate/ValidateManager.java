package business.concreate;

import business.abstracts.Validator;
import dataAccess.abstracts.UserDao;
import entities.concreate.User;

public class ValidateService implements Validator {

    UserDao userDao;

    public ValidateService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean isEMailValid(User user) {


        if(userDao.getByEmail(user.getE_mail())!=null){
            System.out.println("E posta kullanımda!");
            return true;
        }

        if(user.getE_mail().contains("@")){
            return true;
        }
        System.out.println("Geçersiz E-Posta Adresi!");

        return false;
    }

    @Override
    public boolean isNameValid(User user) {
        if(user.getName().length()>2){
            return true;
        }
        System.out.println("Adınız 2 karakterden uzun olmalı!");
        return false;
    }

    @Override
    public boolean isSurnameValid(User user) {
        if(user.getSurname().length()>2){
            return true;
        }
        System.out.println("Soyadınız 2 karakterden uzun olmalı!");
        return false;
    }

    @Override
    public boolean isPasswordValid(User user) {
        if(user.getPassword().length()>5){
            return true;
        }
        System.out.println("Şifreniz 2 karakterden uzun olmalı!");
        return false;
    }
}
