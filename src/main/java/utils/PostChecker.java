package utils;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PostChecker {

    public static List<String> checkPostData(Map<String, String> postData){
        List<String> errorParam = new ArrayList();
        postData.forEach((name, value) -> {
            if(value == null || value.equals("")){
                errorParam.add(name);
            }
        });
        return errorParam;
    }

    public static String setErrorMessage(List<String> errorParams){
        String errorMessage = "Les champs suivants sont obligatoire : ";
        for (String param : errorParams){
            errorMessage += param + ", ";
        }
        return errorMessage;
    }

    public static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }
}
