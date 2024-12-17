package by.yvesRocher.ui.utils.random;

import com.github.javafaker.Faker;

public class RandomData {
    private static Faker faker = new Faker();

    public static String generateEmail() {
        return faker.internet().emailAddress();
    }

    public static String generateLastname(){
        return faker.name().lastName();
    }

    public static String generateName(){
        return faker.pokemon().name();
    }

    public static String generatePassword(int min, int max) {
        int minLength = min;
        int maxLength = max;
        return faker.internet().password(minLength, maxLength);
    }
}
