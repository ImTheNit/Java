package nonLiving;

public enum EnumEntity {
	
	None(true,""),
	
	Tree1Day(false,"Tree1Day"),
	
	//Knight(false,"knights"),
	//Zombie(false,"zombie")
	
	;
	

	private boolean crossable;
	private String sprite;
	
	/*
	 * constructor
	 */
	EnumEntity(boolean b,String s){
		setCrossability(b);
		setSprite(s);
	}
	/*
	 * getter
	 */
	public boolean isCrossable() {
		return crossable;
	}
	public String getSprite() {
		return sprite;
	}
	
	/*
	 * setter
	 */
	public void setCrossability(boolean b) {
		crossable =b;
	}
	public void setSprite(String s) {
		sprite=s;
	}
	
}
