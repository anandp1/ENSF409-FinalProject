package backendclasses;

public enum Quadrant {
	SW(1), NW(2), NE(3), SE(4);

	private int number;
	
	public int getInt() {
		return number;
	}
	
	Quadrant(int i) {
		number = i;
	}

	static public Quadrant fromInt(int i) {
		switch(i) {
			case 1:
				return SW;
			case 2:
				return NW;
			case 3:
				return NE;
			case 4:
				return SE;
		}
		return null;
	}
}
