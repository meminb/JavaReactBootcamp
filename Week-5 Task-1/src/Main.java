import business.concreate.UserManager;
import business.concreate.ValidateManager;
import core.concreate.GoogleAdapter;
import core.concreate.VerificationManager;
import dataAccess.abstracts.UserDao;
import dataAccess.concreate.savedUserDao;
import entities.concreate.User;
import google.abstracts.GoogleServices;
import google.concreate.GoogleSignIn;

public class Main {

    public static void main(String[] args) {


        UserDao userDao=new savedUserDao();
        ValidateManager validateManager =new ValidateManager(userDao);
        VerificationManager verificationManager=new VerificationManager();
        GoogleAdapter adapter=new GoogleAdapter(new GoogleSignIn());

        UserManager userManager=new UserManager(validateManager,userDao,verificationManager);
        UserManager userManager2=new UserManager(validateManager,userDao,adapter);

        User user1=new User("Ahmet","Kahya","ahmetkahya@hotmail.com","ahmet123");
        User user2=new User("Ayşe ","Demir","ayşe@hotmail.com","ayşe123");
        User user3=new User("Deniz","Ateş","deniz@hotmail.com","ahmet123");
        User user4=new User("veli","elmacı","veli@hotmail.com","ahmet123");
        User user5=new User("ilayda","gediz","ilaydaweotmail.com","ahmet123");//Invalid email


        userManager.signUp(user1);
        userManager.verify(user1);
        System.out.println("_______________________________");

        userManager.signUp(user2);
        userManager.verify(user2);
        System.out.println("_______________________________");

        userManager.signUp(user3);
        userManager.verify(user3);
        System.out.println("_______________________________");

        userManager.signUp(user4);
        userManager.verify(user4);
        System.out.println("_______________________________");

        userManager.signUp(user5);
        userManager.verify(user5);
        System.out.println("_______________________________");


        userManager.login(user1.getE_mail(),user1.getPassword());

        User gUser=new User("Behzat","Çetin","behzat@gmail.com","behzat123");
        userManager2.signUp(gUser);
        userManager2.verify(gUser);

    }
}
