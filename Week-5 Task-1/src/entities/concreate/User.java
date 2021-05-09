package entities.concreate;

import entities.abstracts.entity;

public class User implements entity {
    String name,surname,e_mail,password;
    boolean isValidated;

    public User(String name, String surname, String e_mail, String password) {
        this.isValidated=false;
        this.name = name;
        this.surname = surname;
        this.e_mail = e_mail;
        this.password = password;
    }

    public boolean isValidated() {
        return isValidated;
    }
    public void verifyUser(){
        isValidated=true;
    }

    public void setValidated(boolean validated) {
        isValidated = validated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
