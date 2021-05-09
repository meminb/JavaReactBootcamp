package google.concreate;

import google.abstracts.GoogleServices;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GoogleSignIn implements GoogleServices {



    @Override
    public boolean authWithGoogle(String mail) {
        Pattern pattern = Pattern.compile("^(.+)@gmail(.+)$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(mail);
        if (!matcher.matches()) {
            return false;
        }
        return true;
    }
}
