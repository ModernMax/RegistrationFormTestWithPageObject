package utils;

import java.util.Random;

public class RandomUtils {
    public static int getRandomNumberUsingInts(int min, int max) {
        Random random = new Random();
        return random.ints(min, max)
                .findFirst()
                .getAsInt();
    }

    public static String getRandomGender(){
        String[] gender = {"Female", "Male", "Other"};
        int genderIndex = getRandomNumberUsingInts(0,2);
        return gender[genderIndex];
    }

    public static String getRandomHobby(){
        String[] hobby = {"Sports", "Reading", "Music"};
        int hobbyIndex = getRandomNumberUsingInts(0,2);
        return hobby[hobbyIndex];
    }

    public static String getRandomSubject(){
        String[] subject = {
                "Physics",
                "Chemistry",
                "Computer Science",
                "Commerce",
                "Accounting",
                "Economics",
                "Social Studies",
                "Civics",
                "Maths",
                "Arts"
        };
        int subjectIndex = getRandomNumberUsingInts(0,9);
        return subject[subjectIndex];
    }
}
