package backendclasses;//package Main;

public class Fee {
    private double feeAmount;
    private int period;
    public Fee(double feeAmount, int period) {
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