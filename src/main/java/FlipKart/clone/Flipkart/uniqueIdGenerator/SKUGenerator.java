package FlipKart.clone.Flipkart.uniqueIdGenerator;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

public class SKUGenerator {
    private static final String CHAR_POOL = "0123456789";
    private static final SecureRandom random = new SecureRandom();
    private static final Set<String> generatedIds = new HashSet<>();

    public static String generateUniqueSKUId() {
        String SKUId;
        do {
            SKUId = randomString(16);
        } while (generatedIds.contains(SKUId));

        generatedIds.add(SKUId);
        return SKUId;
    }

    private static String randomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            if (i % 4 == 0 && i != 0) {
                sb.append("-");
            }
            int index = random.nextInt(CHAR_POOL.length());
            sb.append(CHAR_POOL.charAt(index));
        }
        return sb.toString();
    }
}
