package utils;

import java.util.Base64;

public final class DecodeUtil {

    private DecodeUtil() {
    }

    public static String decodeBase64ToString(String base64EncodeValue) {
        byte[] decodeBytes = Base64.getDecoder().decode(base64EncodeValue);
        return new String(decodeBytes);
    }
}