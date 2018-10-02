package by.fraiman.models.enums;

public enum ActivityLevel {
    SEDENTARY(1.200, "Little or no exercise"),
    LIGHTLY(1.375, "Light exercise/sports 1-3 days/week"),
    MODERATELY(1.550, "Moderate exercise/sports 3-5 days/week"),
    VERY(1.725, "Hard exercise/sports 6-7 days a week"),
    EXTRA(1.900, "Very hard exercise/sports and physical job");

    double activityLevel;
    String description;

    ActivityLevel(double activityLevel, String description) {
        this.activityLevel = activityLevel;
        this.description = description;
    }

    public static ActivityLevel getActivity(String description) {

        for (ActivityLevel activityLevel : ActivityLevel.values()) {
            if (activityLevel.getDescription().equals(description))
                return activityLevel;
        }
        return null;
    }

    public double getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(double activityLevel) {
        this.activityLevel = activityLevel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
