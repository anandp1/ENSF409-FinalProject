package Main;

public class Property {
	private final int property_id;
    private final String apartmentType;
    private final Integer numBed;
    private final Integer numBath;
    private final Quadrant quadrant;
    private final boolean isFurnished;
    private final Listing listing;
    Property(int property_id, String apartmentType, Integer numBed, Integer numBath, Quadrant quadrant, boolean isFurnished, Listing listing) {
        this.property_id = property_id;
        this.apartmentType = apartmentType;
        this.numBath = numBath;
        this.numBed = numBed;
        this.quadrant = quadrant;
        this.isFurnished = isFurnished;
        this.listing = listing;
    }
    public int getPropertyID() {
    	return property_id;
    }
    public String getApartmentType() {
        return apartmentType;
    }
    public Integer getNumBed() {
        return numBed;
    }
    public Integer getNumBath() {
        return numBath;
    }
    public Quadrant getQuadrant() {
        return quadrant;
    }
    public boolean getIsFurnished() {
        return isFurnished;
    }

    public Listing getListing() {
        return listing;
    }
}
