package elmt_Base;

public class Point1D {
	private int abscisse ;
	
	/*
	 * Constructor
	 */
	public Point1D(int a) {
		this.setAbscisse(a);
	}
	
	/*
	 * getter
	 */
	public int getAbscisse() {
		return this.abscisse;
		
	}
	/*
	 * setter
	 */
	public void setAbscisse(int a) {
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
