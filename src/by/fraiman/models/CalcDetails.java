package by.fraiman.models;

import by.fraiman.models.enums.ActivityLevel;
import by.fraiman.models.enums.Gender;

public class CalcDetails {
    private Double height;
    private Double weight;
    private Double age;
    private ActivityLevel active;
    private Gender gender;

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "CalcDetails{" +
                "height=" + height +
                ", weight=" + weight +
                ", age=" + age +
                ", active=" + active +
                ", gender=" + gender +
                '}';
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getAge() {
        return age;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    public ActivityLevel getActive() {
        return active;
    }

    public void setActive(ActivityLevel active) {
        this.active = active;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
