
public class Listing {
    private String listingState;
    private Fee fee;

    private int daysCount;
    Listing(String listingState, Fee fee, int daysCount) {
        this.listingState = listingState;
        this.fee = fee;
        this.daysCount = daysCount;

    }
    public void addDay() {
        daysCount++;
    }
    public void contactLandlords(String message) {
        // might change
    }
    public void setListingState(String listingState, String userID) {

    }
    public String getListingState() {
        return listingState;
    }
    public Fee getFee() {
        return fee;
    }
    public int getDaysCount() {
        return daysCount;
    }

}
