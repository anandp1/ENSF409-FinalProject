package backendclasses;

public enum State {
	ACTIVE(1), RENTED(2), CANCELLED(3), SUSPENDED(4);

	private int number;
	
	public int getInt() {
		return number;
	}
	
	State(int i) {
		number = i;
	}
}
