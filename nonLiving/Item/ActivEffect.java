package nonLiving.Item;

public enum ActivEffect {
	SMALL_HEAL(20),
	MEDIUM_HEAL(30),
	BIG_HEAL(40),
	
	
	NONE(0);
	
	
	
	
	

	private int value;
	
	/*
	 * constructor
	 */
	
	ActivEffect(int i) {
		setValue(i);
	}
	
	
	/*
	 * getter
	 */
	
	public int getValue() {
		return value;
	}
	
	
	
	/*
	 * setter
	 */
	
	public void setValue(int val) {
		value = val;
	}
	
	@Override
	public String toString() {
		String ret = "\nName : "+this.name();
		ret += "\nValue : "+getValue();
		return ret ;
	}
	
}
