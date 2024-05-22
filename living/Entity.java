package living;

import elmt_Base.Direction;
import elmt_Base.Point2D;

public class Entity {
	private Point2D position ;
	private double weight;
	private Direction facing;


	/*
	 * Constructor
	 */
	public Entity(double x,double y, double w,Direction f) {
		setPosition(x,y);
		setWeight(w);
		setFacing(f);
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
	
	
	/*
	 * setter
	 */
	public void setPosition(double x,double y) {
		position= new Point2D(x,y);
	}
	
	public void setWeight(double x) {
		weight = x;
	}
	
	public void setFacing(Direction f) {
		facing = f;
	}
	
	/*
	 * Methods
	 */
	public void move(double deltaX, double deltaY) {
		getPosition().setAbscisse(getPosition().getAbscisse()+deltaX);
		getPosition().setOrdonnee(getPosition().getOrdonnee()+deltaY);
	}
	
	
	
	
	
	@Override
	public String toString() {
		return getPosition().toString()+"\nweight :"+getWeight()+"\nfacing :"+getFacing();
	}
}