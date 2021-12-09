package backendclasses;

public class Message {
    private final String renter_email;
    private final String message;

    public Message(String renter_email, String message) {
        this.renter_email = renter_email;
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    public String getRenterEmail(){
        return renter_email;
    }
}
