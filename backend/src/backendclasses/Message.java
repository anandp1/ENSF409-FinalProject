package backendclasses;

// used to hold messages between landlords and renters
public class Message {
    // attributes
    private final String renter_email;
    private final String message;

    // constructor
    public Message(String renter_email, String message) {
        this.renter_email = renter_email;
        this.message = message;
    }

    // getters
    public String getMessage(){
        return message;
    }
    public String getRenterEmail(){
        return renter_email;
    }
}
