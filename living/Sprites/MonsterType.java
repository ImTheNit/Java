package living.Sprites;

public enum MonsterType {
	
	None("",1,1,1,1,1,1),
	
	Zombie("zombie",1,2,3,100,5,6),
	//Squeleton("squeleton",1,2,100,4,5,6),
	Knight("knight",1,2,3,100,20,20)
	
	
	
	;
	private String texture;
	private int level;
	private int xp;
	private int xpMax;
	private double life;
	private double atk;
	private double def;
	
	
	/*
	 * Constructor
	 */
	
	MonsterType(String texture,int Level,int Xp, int XpMax,double Life, double Atk, double Def) {
		
		setTexture(texture);
		setLevel(Level);
		setXp(Xp);
		setXpMax(XpMax);
		setLife(Life);
		setAtk(Atk);
		setDef(Def);
	}
	
	/*
	 * getter
	 */
	
	public String getTexture() {
		return texture;
	}
	public int getLevel() {
		return level;
	}
	public int getXp() {
		return xp;
	}
	public int getXpMax() {
		return xpMax;
	}
	public double getLife() {
		return life;
	}
	public double getAtk() {
		return atk;
	}
	public double getDef() {
		return def;
	}
	
	/*
	 * setter
	 */
	
	
	public void setTexture(String t) {
		texture = t;
	}
	public void setLevel(int x) {
		level = x;
	}
	
	public void setXp(int x) {
		xp = x;
	}public void setXpMax(int x) {
		xpMax = x;
	}
	public void setLife(double x) {
		life = x;
	}
	public void setAtk(double x) {
		atk = x;
	}
	public void setDef(double x) {
		def = x;
	}
	
	
	
	
}
