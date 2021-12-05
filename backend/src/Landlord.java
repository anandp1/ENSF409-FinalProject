import java.util.ArrayList;

public class Landlord {
    private ArrayList<Property> properties;
    private int landlordID;
    Landlord(int landlordID, ArrayList<Property> properties) {
        this.landlordID = landlordID;
        this.properties = properties;
    }
    public void registerProperty(String apartmentType, Integer numBed, Integer numBath, String quadrant, boolean isFurnished) {
        // call database using landlordID and save all this info
        // add it to all the properties in the database
        // in the database each property has a id to it indicating the landlord that in charge of it

    }
    public void messageRenter(String message, int renterID) {
        // save message for the renterID in the database
    }
    public void processPayment() {
        // update the payment to 1 from 0 in the database indicating has paid
    }
    public void postProperty() {
        // turns the property that is associated with this landlords id
        // into active only if it its currently suspended
    }
    public ArrayList<Property> getProperty() {
        // get all properties associated with the landlord id from database
        return properties;
    }



}
