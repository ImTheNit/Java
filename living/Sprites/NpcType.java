package living.Sprites;

public enum NpcType {
	Jean("jean",1,2,3,4,5,6),
	Theo("theo",1,2,3,4,5,6),
	Nathan("nathan",1,2,3,4,5,6)
	
	
	
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
	
	NpcType(String texture,int Level,int Xp, int XpMax,double Life, double Atk, double Def) {
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
