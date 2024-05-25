package living;

import elmt_Base.Direction;
import elmt_Base.Point2D;
import nonLiving.EnumEntity;

public class Entity {
	private Point2D position ;
	private double weight;
	private Direction facing;
	private EnumEntity type;


	/*
	 * Constructor
	 */
	public Entity(int x,int y, double w,Direction f,EnumEntity e) {
		setPosition(x,y);
		setWeight(w);
		setFacing(f);
		setType(e);
	}
	
	/*
	 * getter
	 */
	public Point2D getPosition() {
		return position;
		
	}
	public double getWeight() {
		return weight;
	}
	
	public Direction getFacing() {
		return facing;
	}
	public EnumEntity getType() {
		return type;
	}
	
	/*
	 * setter
	 */
	public void setPosition(int x,int y) {
		position= new Point2D(x,y);
	}
	
	public void setWeight(double x) {
		weight = x;
	}
	
	public void setFacing(Direction f) {
		facing = f;
	}
	
	public void setType(EnumEntity t) {
		type = t;
	}
	/*
	 * Methods
	 */
	public void move(int deltaX, int deltaY) {
		
		getPosition().setAbscisse(getPosition().getAbscisse()+deltaX);
		getPosition().setOrdonnee(getPosition().getOrdonnee()+deltaY);
	}
	
	
	
	
	
	@Override
	public String toString() {
		return getPosition().toString()+"\nweight :"+getWeight()+"\nfacing :"+getFacing();
	}
}