package FlipKart.clone.Flipkart.uniqueIdGenerator;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

public class GSTNumberGenerator {

    private static final String CHAR_POOL = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final SecureRandom random = new SecureRandom();
    private static final Set<String> generatedIds = new HashSet<>();

    public static String generateGSTId() {
        String GSTId;
        do {
            GSTId = randomString(15);
        } while (generatedIds.contains(GSTId));

        generatedIds.add(GSTId);
        return GSTId;
    }

    private static String randomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHAR_POOL.length());
            sb.append(CHAR_POOL.charAt(index));
        }
        return sb.toString();
    }

}
