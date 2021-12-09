package backendclasses;

public class Criteria {

    private final String apartmentType;
    private final Integer numBed;
    private final Integer numBath;
    private final Quadrant quadrant;
    private final boolean isFurnished;

    public Criteria(String apartmentType, Integer numBed, Integer numBath, Quadrant quadrant, boolean isFurnished) {
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
    public Quadrant getQuadrant() {
        return quadrant;
    }
    public boolean getIsFurnished() {
        return isFurnished;
    }
    public int intIsFurnished(){
        if(isFurnished) return 1;
        else return 0;
    }
}
