package by.yvesRocher.ui.utils.random;

import com.github.javafaker.Faker;

import java.util.Random;

public class RandomData {
    private static Faker faker = new Faker();

    public static String generateEmail() {
        return faker.internet().emailAddress();
    }

    public static String generateLastname(){
        return faker.name().lastName();
    }

    public static String generateName(){
        return faker.name().name();
    }

    public static String generatePassword(int min, int max) {
        int minLength = min;
        int maxLength = max;
        return faker.internet().password(minLength, maxLength);
    }

    public static int generateRandomDay() {
        return (int) (Math.random() * 31) + 1;
    }

    public static int generateRandomMonth() {
        return (int) (Math.random() * 12) + 1;
    }

    public static int generateRandomYear() {
        int minYear = 1900;
        int maxYear = 2024;
        Random random = new Random();
        return random.nextInt(maxYear - minYear + 1) + minYear;
    }
}
