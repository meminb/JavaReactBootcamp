package business.concreate;

import business.abstracts.Validator;
import dataAccess.abstracts.UserDao;
import entities.concreate.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateManager implements Validator {

    UserDao userDao;

    public ValidateManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean isEMailValid(User user) {
        final Pattern VALID_EMAIL_ADDRESS_REGEX =
                Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

        if(userDao.getByEmail(user.getE_mail())!=null){
            System.out.println("E posta kullanımda!");
            return true;
        }

        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(user.getE_mail());
        if(matcher.find()){
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
