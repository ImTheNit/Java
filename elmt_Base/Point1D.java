package elmt_Base;

public class Point1D {
	private double abscisse ;
	
	/*
	 * Constructor
	 */
	public Point1D(double a) {
		this.setAbscisse(a);
	}
	
	/*
	 * getter
	 */
	public double getAbscisse() {
		return this.abscisse;
		
	}
	/*
	 * setter
	 */
	public void setAbscisse(double a) {
		this.abscisse=a;
	}
	
	
	
	/*
	 * methods
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof Point1D) {
			return (((Point1D)o).getAbscisse()==this.getAbscisse());
		}else
			return false;
	}
	
	
	@Override
	public String toString() {
		return ("\nabscisse :"+this.getAbscisse());
	}
	
}
