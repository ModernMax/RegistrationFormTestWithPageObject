package utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static int randomValue(final int to) {
        return ThreadLocalRandom.current().nextInt(to);
    }


    public static String getRandomState() {
        List<String> states = List.of("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
        return states.get(RandomUtils.randomValue(states.size()));
    }

    public static String getRandomCity(String states) {
        Map<String, List<String>> cities = new HashMap<>();
        cities.put("NCR", List.of("Delhi", "Gurgaon", "Noida"));
        cities.put("Uttar Pradesh", List.of("Agra", "Lucknow", "Merrut"));
        cities.put("Haryana", List.of("Karnal", "Panipat"));
        cities.put("Rajasthan", List.of("Jaipur", "Jaiselmer"));

        List<String> city = cities.get(states);
        return city.get(RandomUtils.randomValue(city.size()));
    }

    public static String getRandomGender() {
        List<String> gender = List.of("Female", "Male", "Other");
        return gender.get(RandomUtils.randomValue(gender.size()));
    }

    public static String getRandomHobby() {
        List<String> hobby = List.of("Sports", "Reading", "Music");
        return hobby.get(RandomUtils.randomValue(hobby.size()));
    }

    public static String getRandomMonth() {
        List<String> month = List.of(
                "January",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December");
        return month.get(RandomUtils.randomValue(month.size()));
    }

    public static String getRandomDay() {
        return ThreadLocalRandom.current().nextInt(10, 31) + "";
    }

    public static String getRandomYear() {
        return ThreadLocalRandom.current().nextInt(1900, 2100) + "";
    }

    public static String getRandomSubject() {
        List<String> subjects =
                List.of(
                        "Physics",
                        "Chemistry",
                        "Computer Science",
                        "Commerce",
                        "Accounting",
                        "Economics",
                        "Social Studies",
                        "Civics",
                        "Maths",
                        "Arts");
        return subjects.get(RandomUtils.randomValue(subjects.size()));
    }

    public static String getRandomPhone() {
        return RandomStringUtils.randomNumeric(10);
    }


}
