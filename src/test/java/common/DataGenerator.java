package common;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class DataGenerator {

    private static final String[] FIRST_NAMES = {
        "Ava", "Liam", "Sophia", "Noah", "Isabella", "Ethan", "Mia", "Oliver", "Amelia", "James"
    };

    private static final String[] LAST_NAMES = {
        "Smith", "Johnson", "Brown", "Taylor", "Anderson", "Thomas", "Jackson", "White", "Harris", "Martin"
    };

    public static String generateUniqueEmail() {
        return "user_" + System.currentTimeMillis() + "@test.com";
    }

    public static String generateUniqueUsername() {
        return "user_" + UUID.randomUUID().toString().substring(0, 8);
    }

    public static String generateSecurePassword() {
        return "Pwd@" + UUID.randomUUID().toString().substring(0, 8) + "9aA";
    }

    public static String generateFullName() {
        String firstName = FIRST_NAMES[ThreadLocalRandom.current().nextInt(FIRST_NAMES.length)];
        String lastName = LAST_NAMES[ThreadLocalRandom.current().nextInt(LAST_NAMES.length)];
        return firstName + " " + lastName;
    }
    
    
    public static List<String> generateFeetInchRange(String range) {
        String[] parts = range.split("to");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Range must be in the format: 4'5 to 7'3");
        }

        String from = parts[0].trim();
        String to = parts[1].trim();

        int startFeet = Integer.parseInt(from.split("'")[0]);
        int startInches = Integer.parseInt(from.split("'")[1]);
        int endFeet = Integer.parseInt(to.split("'")[0]);
        int endInches = Integer.parseInt(to.split("'")[1]);

        List<String> result = new ArrayList<>();
        for (int ft = startFeet; ft <= endFeet; ft++) {
            int inchStart = (ft == startFeet) ? startInches : 0;
            int inchEnd = (ft == endFeet) ? endInches : 11;
            for (int in = inchStart; in <= inchEnd; in++) {
                result.add(ft + "'" + in + "\"");  // Add the inch symbol here
            }
        }
        return result;
    }


    }


