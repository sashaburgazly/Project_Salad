package sasha.burgazli.App;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CommonService {

    public static String md5(String value) {

        try {
            return new String(MessageDigest.getInstance("MD5").digest(value.getBytes("UTF-8")));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }
}
