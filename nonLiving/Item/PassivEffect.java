package nonLiving.Item;

public enum PassivEffect {
	SMALL_INCREASE_LIFE(10),
	MEDIUM_INCREASE_LIFE(15),
	BIG_INCREASE_LIFE(20),
	
	SMALL_DECREASE_LIFE(10),
	MEDIUM_DECREASE_LIFE(15),
	BIG_DECREASE_LIFE(15),
	
	SMALL_INCREASE_ATK(10),
	MEDIUM_INCREASE_ATK(15),
	BIG_INCREASE_ATK(20),
	
	SMALL_DECREASE_ATK(10),
	MEDIUM_DECREASE_ATK(15),
	BIG_DECREASE_ATK(20),
	
	SMALL_INCREASE_DEF(10),
	MEDIUM_INCREASE_DEF(15),
	BIG_INCREASE_DEF(20),
	
	SMALL_DECREASE_DEF(10),
	MEDIUM_DECREASE_DEF(15),
	BIG_DECREASE_DEF(20),
	
	SMALL_INCREASE_STORAGE(5),
	MEDIUM_INCREASE_STORAGE(10),
	BIG_INCREASE_STORAGE(15),
	
	SMALL_DECREASE_STORAGE(5),
	MEDIUM_DECREASE_STORAGE(10),
	BIG_DECREASE_STORAGE(15),
	
	NONE(0)
	;
	
	

	private int value;
	
	/*
	 * constructor
	 */
	
	PassivEffect(int i) {
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
