package javaapplication2;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class constant {

    public static final String userDBFile = "./registeredUser.txt";
    public static final String REGEX = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";
    private static final String EMAIL_REGEX ="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String PHONENUMBER_REGEX ="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    private static final Pattern PHONENUMBER_PATTERN = Pattern.compile(PHONENUMBER_REGEX);
    public static final String rechargeIGoCardDBFile = "./rechargeIGoCardInformmation.txt";
    public static final String purchaseTicketDBFile = "./purchaseTicketInformmation.txt";
    
    public static boolean isValidEmail(String email) {
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }
    
    public static boolean isValidPhoneNumber(String phoneNumber) {
        //System.out.println("PN:"+phoneNumber);
        Matcher matcher = PHONENUMBER_PATTERN.matcher(phoneNumber);
        return matcher.matches();
    }
    
    /*
        Here are some examples of phone numbers that would match this regular expression:

        416-555-1234
        1-604-555-1234
        (613)555-1234
        905 555 1234
        And here are some examples of phone numbers that would not match:

        555-1234 (missing area code)
        1-800-555-1234 (toll-free number)
        555-1234 ext. 5678 (contains extension)
    */
    
}
