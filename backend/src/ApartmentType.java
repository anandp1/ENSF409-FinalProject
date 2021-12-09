public enum ApartmentType {
    ATTACHED(1), DETACHED(2), TOWNHOUSE(3);

    private int num;

    public int getInt() {
        return num;
    }
    ApartmentType(int num) {
        this.num = num;
    }
}
