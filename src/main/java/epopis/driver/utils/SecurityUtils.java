package epopis.driver.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class SecurityUtils {
    public static String hash(String plaintext) {
        return DigestUtils.sha256Hex(plaintext);
    }
}
