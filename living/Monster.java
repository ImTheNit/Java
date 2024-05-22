package living;

import elmt_Base.Direction;

public class Monster extends LivingEntity {

	
	
	
	/*
	 * constructor
	 */
	public Monster(double x, double y, double weight,Direction Facing,int level,int xp,int xpmax,double life, double atk,double def,String name) {
		super(x, y, weight, Facing,level,xp,xpmax,life,atk,def,name);
		
	}

	public Monster(double x, double y, double weight,Direction Facing,double life, double atk,double def,String name) { // constructor light
		super(x,y,weight,Facing,life,atk,def,name);
	}

}
