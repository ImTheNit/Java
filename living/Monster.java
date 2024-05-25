package living;

import elmt_Base.Direction;
import javafx.scene.layout.StackPane;
import living.Sprites.*;
import nonLiving.EnumEntity;

public class Monster extends LivingEntity {
	
	private MonsterType typeMonster;
	private StackPane sPane;
	
	/*
	 * constructor
	 */
	public Monster(int x, int y, double weight,Direction Facing,int level,int xp,int xpmax,double life, double atk,double def,String name,MonsterType type) {
		super(x, y, weight, Facing,EnumEntity.None,level,xp,xpmax,life,atk,def,name);
		setTypeMonster(type);
		setStackPane(new StackPane());
		
	}

	public Monster(int x, int y, double weight,Direction Facing,double life, double atk,double def,String name,MonsterType type) { // constructor light
		super(x,y,weight,Facing,EnumEntity.None,life,atk,def,name);
		setTypeMonster(type);
		setStackPane(new StackPane());
	}

	
	
	/*
	 * getter
	 */
	
	public MonsterType getTypeMonster() {
		return typeMonster;
	}
	public StackPane getStackPane() {
		return sPane;
	}
	
	/*
	 * setter
	 */
	
	public void setTypeMonster(MonsterType t) {
		typeMonster = t;
	}
	public void setStackPane(StackPane s) {
		sPane = s;
	}
	
	
	/*
	 * methods
	 */
	
	public String sprite() {
		return getTypeMonster().getTexture();
	}
	
	
	
}
