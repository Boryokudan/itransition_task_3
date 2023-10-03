import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

public class HMACGenerator {
    private final static int bitLength = 256;

    public static byte[] generateRandomKey() {
        try {
            SecureRandom random = SecureRandom.getInstanceStrong();
            byte[] key = new byte[bitLength / 8];
            random.nextBytes(key);
            return key;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] computeHMAC(byte[] key, byte[] data) {
        try {
            Mac sha3HMAC = Mac.getInstance("HmacSHA3-256");
            SecretKeySpec secretKeySpec = new SecretKeySpec(key, "HmacSHA3-256");
            sha3HMAC.init(secretKeySpec);
            return sha3HMAC.doFinal(data);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String encodeBase64(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }

    public static byte[] decodeBase64(String base64) {
        return Base64.getDecoder().decode(base64);
    }

    public static byte[] hexToBytes(String hexString) {
        int len = hexString.length();
        byte[] byteArray = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            byteArray[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4)
                    + Character.digit(hexString.charAt(i+1), 16));
        }
        return byteArray;
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }
}
