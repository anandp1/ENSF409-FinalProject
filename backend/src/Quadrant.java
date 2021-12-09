package Main;

public enum Quadrant {
	SW(1), NW(2), NE(3), SE(4);

	private int number;
	
	public int getInt() {
		return number;
	}
	
	Quadrant(int i) {
		number = i;
	}
}
