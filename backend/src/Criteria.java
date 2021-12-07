public class Criteria {

    private final String apartmentType;
    private final Integer numBed;
    private final Integer numBath;
    private final String quadrant;
    private final boolean isFurnished;

    Criteria(String apartmentType, Integer numBed, Integer numBath, String quadrant, boolean isFurnished) {
        this.apartmentType = apartmentType;
        this.numBath = numBath;
        this.numBed = numBed;
        this.quadrant = quadrant;
        this.isFurnished = isFurnished;
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
    public String getQuadrant() {
        return quadrant;
    }
    public boolean getIsFurnished() {
        return isFurnished;
    }
}
