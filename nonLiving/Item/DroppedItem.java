package nonLiving.Item;
import elmt_Base.*;
import nonLiving.NonLivingEntity;


public class DroppedItem extends NonLivingEntity {

	private int quantity;
	private Item item;
	
	/*
	 * constructor
	 */
	public DroppedItem(double x, double y, double z,Direction Facing,Item item,int quantity) {
		super(x, y, z,Facing);
		setQuantity(quantity);
		setItem(item);
	}
	public DroppedItem(Item item, int quantity) {
		super(0,0,0,Direction.Left);
		setQuantity(quantity);
		setItem(item);
	}

	/*
	 * getters
	 */
	
	public int getQuantity() {
		return quantity;
	}
	
	public Item getItem() {
		return item;
	}
	
	/*
	 * setters
	 */
	
	public void setQuantity(int x) {
		quantity = x;
	}
	public void setItem(Item i) {
		item = i;
	}
	
	
	
	/*
	 * methods
	 */
	
	
	
	public Item pick(int x) {
		if (x < getQuantity()) {
			setQuantity(getQuantity()-x);
		}else {
			setQuantity(0);
		}
		return getItem();// supprimer ensuite ?
	}
	
	public Item pickOne() {
		return pick(1);
	}
	
	public Item pickAll() {
		return pick(getQuantity());
	}
	
	@Override
	public String toString() {
		String ret = super.toString();
		ret += "\nquantity : "+getQuantity();
		ret += getItem().toString();
		return ret;
						
	}
}
