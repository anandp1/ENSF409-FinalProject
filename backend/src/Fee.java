//package Main;

public class Fee {
    private double feeAmount;
    private int period;
    Fee(double feeAmount, int period) {
        this.feeAmount = feeAmount;
        this.period = period;
    }
    public double getFeeAmount() {
        return feeAmount;
    }
    public int getPeriod() {
        return period;
    }
}