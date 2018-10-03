package by.fraiman.models;

public class LossCalculator {
    public static double calculate(CalcDetails calcDetails, double curDailyNeeds) {
        double dailyNeeds;

        double difference = calcDetails.getWeight() - calcDetails.getdWeight();

        double dailyLoss = calcDetails.getLossPerWeek() / 7;
        double dietLength = difference / dailyLoss;

        double diffInCal = difference * 7700;

        dailyNeeds = curDailyNeeds - diffInCal / dietLength;
        return dailyNeeds;
    }
}
