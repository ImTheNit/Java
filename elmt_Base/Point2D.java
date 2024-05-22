package elmt_Base;

public class Point2D extends Point1D {

	private double ordonnee;
	
	/*
	 * Constructor
	 */
	public Point2D(double a, double b) {
		super(a);
		this.setOrdonnee(b);
	}
	/*
	 * getter
	 */
	public double getOrdonnee() {
		return this.ordonnee;
	}
	/*
	 * setter
	 */
	public void setOrdonnee(double a) {
		this.ordonnee=a;
	}
	
	
	/*
	 * methods
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof Point2D) {
			Point2D p = (Point2D) o;
			return super.equals(p) && this.getOrdonnee()==p.getOrdonnee();
		}else
			return false;
		
	}
	
	@Override
	public String toString() {
		return(super.toString()+"\nordonnee :"+getOrdonnee());
	}
}
