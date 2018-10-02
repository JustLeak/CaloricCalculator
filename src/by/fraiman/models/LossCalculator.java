package by.fraiman.models;

public class LossCalculator {
    public static double calculate(double curWeight, double desWeight, double lossPerWeek, double curDailyNeeds) {
        double dailyNeeds = 0;

        double difference = curWeight - desWeight;

        double dailyLoss = lossPerWeek / 7;
        double dietLength = difference / dailyLoss;

        double diffInCal = difference * 7700;

        dailyNeeds = curDailyNeeds - diffInCal / dietLength;
        return dailyNeeds;
    }
}
