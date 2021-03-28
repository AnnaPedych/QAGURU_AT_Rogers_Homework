package tests;

import com.github.javafaker.Faker;

public class TestData {
    static Faker faker = new Faker();

    public static int firstAnswer = faker.number().numberBetween(0, 9);
    public static int secondAnswer = faker.number().numberBetween(0, 11);
    public static int thirdAnswer = faker.number().numberBetween(12, 16);
    public static int fourthAnswer = faker.number().numberBetween(17, 18);
}
