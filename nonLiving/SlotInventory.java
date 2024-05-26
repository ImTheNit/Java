package nonLiving;

import java.util.ArrayList;

import event.GameEventHandler;
import nonLiving.Item.Item;
import nonLiving.Item.ItemEnum;

public class SlotInventory implements Cloneable{

	
	
	private Item item;
	private int quantity;
	private boolean isFull;
	private ArrayList<GameEventHandler<SlotInventory>> eventHandlers;
	/*
	 * constructor
	 */
	public SlotInventory(Item i,int x,boolean f) {
		setItem(i);
		setQuantity(x);
		setIsFull(f);
		eventHandlers = new ArrayList<GameEventHandler<SlotInventory>>();
	}
	public SlotInventory() { //constructor for empty item
		this(new Item(),0,false);
	}
	
	/*
	 * getter
	 */
	
	public Item getItem() {
		return item;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public boolean getIsFull() {
		return isFull;
	}
	
	/*
	 * setter
	 */
	
	public void setItem(Item i) {
		item = i;
	}
	public void setQuantity(int x) {
		quantity = x;
	}
	public void setIsFull(boolean f) {
		isFull = f;
	}
	
	/*
	 * methods
	 */
	public boolean isEmpty() {
		if (getItem().getItemEnum()==ItemEnum.EMPTY) {
			return true;
		}else {
			return false;
		}
	}
	public Object clone() throws CloneNotSupportedException 
    { 
        return super.clone(); 
    } 
	@Override
	public String toString() {
		if (getItem()!=null) {
			String ret = "\nItem : "+getItem().toString();
			ret += "\n\nQuantity : "+getQuantity();
			ret += "\nisFull : "+getIsFull()+"\n";
			return ret;
		}
		return null;
	}

	/*
	 * add an event handler
	 */
	public void addEventHandler(GameEventHandler<SlotInventory> handler) {
		eventHandlers.add(handler);
		// TODO Auto-generated method stub
		
	}
}
