package nonLiving.Item;
import elmt_Base.*;
import javafx.scene.layout.StackPane;
import nonLiving.*;




public class DroppedItem extends NonLivingEntity {

	private int quantity;
	private Item item;
	private StackPane sPane;
	
	/*
	 * constructor
	 */
	public DroppedItem(int x, int y, double z,Direction Facing,Item item,int quantity) {
		super(x, y, z,Facing,EnumEntity.None);
		setQuantity(quantity);
		setItem(item);
	}
	public DroppedItem(Item item, int quantity) {
		super(0,0,0,Direction.Left,EnumEntity.None);
		setQuantity(quantity);
		setItem(item);
	}
	public DroppedItem() {
		super(0,0,0,Direction.Left,EnumEntity.Tree1Day);
		setItem(new Item(ItemEnum.NONE));
		setQuantity(1);
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
	public StackPane getStackPane() {
		return sPane;
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
	public void setStackPane(StackPane s) {
		sPane = s;
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
