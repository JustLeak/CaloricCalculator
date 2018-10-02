package by.fraiman.models;

import by.fraiman.models.enums.Gender;

public class BMRCalculator {
    public static Double getBMR(CalcDetails details) {
        double a = 10 * details.getWeight();
        double b = 6.25 * details.getHeight();
        double c = 5 * details.getAge();
        double BMR;
        double dailyCaloricNeeds;
        if (details.getGender().equals(Gender.MALE)) {
            BMR = a + b;
            BMR -= c + 5;
        } else {
            BMR = a + b;
            BMR -= c - 161;
        }

        dailyCaloricNeeds = BMR * details.getActive().getActivityLevel();
        return dailyCaloricNeeds;
    }
}
