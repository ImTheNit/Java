package nonLiving;

import nonLiving.Item.Item;
import nonLiving.Item.ItemType;
import nonLiving.Item.ItemEnum;

public class ArmorInventory {

	private SlotInventory Helmet;
	private SlotInventory Chest;
	private SlotInventory Greave;
	private SlotInventory Boots;
	private SlotInventory Shield;
	private SlotInventory BackPack;
	
	
	/*
	 * Constructor
	 */
	public ArmorInventory(SlotInventory Helmet,SlotInventory Chest, SlotInventory Greave, SlotInventory Boots, SlotInventory Shield) {
		setHelmet(Helmet);
		setChest(Chest);
		setGreave(Greave);
		setBoots(Boots);
		setShield(Shield);
	}
	public ArmorInventory() {
		SlotInventory NULL = new SlotInventory();
		setHelmet(NULL);
		setChest(NULL);
		setGreave(NULL);
		setBoots(NULL);
		setShield(NULL);
		setBackPack(NULL);
	}
	
	/*
	 * getter
	 */
	
	public SlotInventory getHelmet() {
		return Helmet;
	}
	public SlotInventory getChest() {
		return Chest;
	}
	public SlotInventory getGreave() {
		return Greave;
	}
	public SlotInventory getBoots() {
		return Boots;
	}
	public SlotInventory getShield() {
		return Shield;
	}
	public SlotInventory getBackPack() {
		return BackPack;
	}
	/*
	 * setter
	 */
	
	public void setHelmet(SlotInventory helmet) {
		if (helmet.getItem().getItemEnum()==ItemEnum.EMPTY || helmet.getItem().getItemEnum().getType()==ItemType.HELMET) {
			Helmet = helmet;
		}
	}
	public void setChest(SlotInventory chest) {
		if (chest.getItem().getItemEnum()==ItemEnum.EMPTY ||chest.getItem().getItemEnum().getType()==ItemType.CHEST) {
			Chest = chest;
		}
	}
	public void setGreave(SlotInventory greave) {
		if (greave.getItem().getItemEnum()==ItemEnum.EMPTY ||greave.getItem().getItemEnum().getType()==ItemType.GREAVE) {
			Greave = greave;
		}
	}
	public void setBoots(SlotInventory boots) {
		if (boots.getItem().getItemEnum()==ItemEnum.EMPTY ||boots.getItem().getItemEnum().getType()==ItemType.BOOTS) {
			Boots = boots;
		}
	}
	public void setShield(SlotInventory shield) {
		if (shield.getItem().getItemEnum()==ItemEnum.EMPTY ||shield.getItem().getItemEnum().getType()==ItemType.SHIELD) {
			Shield = shield;
		}
	}
	public void setBackPack(SlotInventory bp) {
		if (bp.getItem().getItemEnum()==ItemEnum.EMPTY ||bp.getItem().getItemEnum().getType()==ItemType.BACKPACK) {
			BackPack = bp;
		}
	}
	/*
	 * methods
	 */
	
	public Item removeHelmet() {
		Item ret = getHelmet().getItem();
		setHelmet(new SlotInventory());
		return ret;
	}
	public Item removeChest() {
		Item ret = getChest().getItem();
		setChest(new SlotInventory());
		return ret;
	}
	public Item removeGreave() {
		Item ret = getGreave().getItem();
		setGreave(new SlotInventory());
		return ret;
	}
	public Item removeBoots() {
		Item ret = getBoots().getItem();
		setBoots(new SlotInventory());
		return ret;
	}
	public Item removeShield() {
		Item ret = getShield().getItem();
		setShield(new SlotInventory());
		return ret;
	}
	public Item removeBackPack() {
		Item ret = getBackPack().getItem();
		setBackPack(new SlotInventory());
		return ret;
	}
	
	
	public void putHelmet(Item Helmet) {
		setHelmet( new SlotInventory(Helmet,1,false));
	}
	public void putChest(Item Chest) {
		setChest(new SlotInventory(Chest,1,false));
	}
	public void putGreave(Item Greave) {
		setGreave(new SlotInventory(Greave,1,false));
	}
	public void putBoots(Item Boots) {
		setBoots(new SlotInventory(Boots,1,false));
	}
	public void putShield(Item Shield) {
		setShield(new SlotInventory(Shield,1,false));
	}
	public void putBackPack(Item bp) {
		setBackPack(new SlotInventory(bp,1,false));
	}
	
	
	
	public Item replaceHelmet(Item Helmet) {
		Item ret = removeHelmet();
		putHelmet(Helmet);
		return ret;
	}
	public Item replaceChest(Item Chest) {
		Item ret = removeChest();
		putChest(Chest);
		return ret;
	}
	public Item replaceGreave(Item Greave) {
		Item ret = removeGreave();
		putGreave(Greave);
		return ret;
	}
	public Item replaceBoots(Item Boots) {
		Item ret = removeBoots();
		putBoots(Boots);
		return ret;
	}
	public Item replaceShield(Item Shield) {
		Item ret = removeShield();
		putShield(Shield);
		return ret;
	}
	public Item replaceBackPack(Item bp) {
		Item ret = removeBackPack();
		putBackPack(bp);
		return ret;
	}
	
	
	@Override
	public String toString() {
		String ret = "\n\tArmor:";
		if (getHelmet()==null || getHelmet().getItem().getItemEnum()!=ItemEnum.EMPTY) {
			ret += "\nHelmet : "+getHelmet().toString();
		}else {
			ret += "\nHelmet : None";
		}
		
		if (getChest()==null || getChest().getItem().getItemEnum()!=ItemEnum.EMPTY) {
			ret += "\nChest : "+getChest().toString();
		}else {
			ret += "\nChest : None";
		}
		
		if (getGreave()==null || getGreave().getItem().getItemEnum()!=ItemEnum.EMPTY) {
			ret += "\nGreave : "+getGreave().toString();
		}else {
			ret += "\nGreave : None";
		}
		
		if (getBoots()==null || getBoots().getItem().getItemEnum()!=ItemEnum.EMPTY) {
			ret += "\nBoots : "+getBoots().toString();
		}else {
			ret += "\nBoots : None";
		}
		
		if (getShield()==null || getShield().getItem().getItemEnum()!=ItemEnum.EMPTY) {
			ret += "\nShield : "+getShield().toString();
		}else {
			ret += "\nShield : None";
		}
		if (getBackPack()==null || getBackPack().getItem().getItemEnum()!=ItemEnum.EMPTY) {
			ret += "\nBackPack : "+getBackPack().toString();
		}else {
			ret += "\nBackPack : None";
		}
		
		return ret;
		}
	
	
	
	
	
}
