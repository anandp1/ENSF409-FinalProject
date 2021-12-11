package backendclasses;//package Main;

public class Fee {

    // attributes
    private double feeAmount;
    private int period;

    // constructors
    public Fee(double feeAmount, int period) {
        this.feeAmount = feeAmount;
        this.period = period;
    }

    // getters
    public double getFeeAmount() {
        return feeAmount;
    }
    public int getPeriod() {
        return period;
    }
}