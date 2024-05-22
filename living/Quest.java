package living;

import java.util.ArrayList;

import elmt_Base.Point1D;
import nonLiving.SlotInventory;

public class Quest {
	private ArrayList<SlotInventory> itemReward=new ArrayList<SlotInventory>(3);
	private int xpReward;
	private int moneyReward;
	
	
	
	/*
	 * Constructor
	 */
	public Quest(ArrayList<SlotInventory> iReward,int xReward, int mReward) {
		
		setItemReward(iReward);
		setXpReward(xReward);
		setMoneyReward(mReward);
		
	}
	
	
	/*
	 * getter
	 */
	
	public ArrayList<SlotInventory> getItemReward() {
		return itemReward;
	}
	public SlotInventory getItemReward(int index) {
		if(index<itemReward.size()) {
			return itemReward.get(index);
		}else {
			System.out.println("Out of bond");
			return null;
		}
	}
	public int getXpReward() {
		return xpReward;
	}
	public int getMoneyReward() {
		return moneyReward;
	}
	
	
	/*
	 * setter
	 */
	public void setItemReward(ArrayList <SlotInventory> items) {
		itemReward = items;
	}
	public void setItemReward(SlotInventory item,int index) {
		itemReward.set(index, item);
	}
	public void setXpReward(int x) {
		xpReward = x;
	}
	public void setMoneyReward(int x) {
		moneyReward = x;
	}
	
	
	/*
	 * methods
	 */
	
	public String SlotInventoryToString() {
		String ret = " item Reward";
		for (int i = 0; i<getItemReward().size();i++) {
			ret += "Item "+i+getItemReward(i).toString();
		}
		return ret;
	}
	
	@Override
	public String toString() {
		String ret = SlotInventoryToString();
		ret += "\nxpReward : "+getXpReward();
		ret += "\nmoneyReward : "+getMoneyReward();
		return ret;
	}
	@Override
	public boolean equals(Object o) {
		if (o instanceof Quest) {
			return (((Quest)o).getItemReward()==getItemReward()) && (((Quest)o).getXpReward()==getXpReward())&& (((Quest)o).getMoneyReward()==getMoneyReward());
		}else
			return false;
	}
	
	
}
