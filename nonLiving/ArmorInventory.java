package nonLiving;

import nonLiving.Item.Item;
import nonLiving.Item.ItemType;
import nonLiving.Item.ItemEnum;

public class ArmorInventory {

	private Item Helmet;
	private Item Chest;
	private Item Greave;
	private Item Boots;
	private Item Shield;
	private Item BackPack;
	
	
	/*
	 * Constructor
	 */
	public ArmorInventory(Item Helmet,Item Chest, Item Greave, Item Boots, Item Shield) {
		setHelmet(Helmet);
		setChest(Chest);
		setGreave(Greave);
		setBoots(Boots);
		setShield(Shield);
	}
	public ArmorInventory() {
		Item NULL = new Item();
		setHelmet(NULL);
		setChest(NULL);
		setGreave(NULL);
		setBoots(NULL);
		setShield(NULL);
	}
	
	/*
	 * getter
	 */
	
	public Item getHelmet() {
		return Helmet;
	}
	public Item getChest() {
		return Chest;
	}
	public Item getGreave() {
		return Greave;
	}
	public Item getBoots() {
		return Boots;
	}
	public Item getShield() {
		return Shield;
	}
	public Item getBackPack() {
		return BackPack;
	}
	/*
	 * setter
	 */
	
	public void setHelmet(Item helmet) {
		if (helmet.getItemEnum()==ItemEnum.EMPTY || helmet.getItemEnum().getType()==ItemType.HELMET) {
			Helmet = helmet;
		}
	}
	public void setChest(Item chest) {
		if (chest.getItemEnum()==ItemEnum.EMPTY ||chest.getItemEnum().getType()==ItemType.CHEST) {
			Chest = chest;
		}
	}
	public void setGreave(Item greave) {
		if (greave.getItemEnum()==ItemEnum.EMPTY ||greave.getItemEnum().getType()==ItemType.GREAVE) {
			Greave = greave;
		}
	}
	public void setBoots(Item boots) {
		if (boots.getItemEnum()==ItemEnum.EMPTY ||boots.getItemEnum().getType()==ItemType.BOOTS) {
			Boots = boots;
		}
	}
	public void setShield(Item shield) {
		if (shield.getItemEnum()==ItemEnum.EMPTY ||shield.getItemEnum().getType()==ItemType.SHIELD) {
			Shield = shield;
		}
	}
	public void setBackPack(Item bp) {
		if (bp.getItemEnum()==ItemEnum.EMPTY ||bp.getItemEnum().getType()==ItemType.BACKPACK) {
			BackPack = bp;
		}
	}
	/*
	 * methods
	 */
	
	public Item removeHelmet() {
		Item ret = getHelmet();
		setHelmet(new Item());
		return ret;
	}
	public Item removeChest() {
		Item ret = getChest();
		setChest(new Item());
		return ret;
	}
	public Item removeGreave() {
		Item ret = getGreave();
		setGreave(new Item());
		return ret;
	}
	public Item removeBoots() {
		Item ret = getBoots();
		setBoots(new Item());
		return ret;
	}
	public Item removeShield() {
		Item ret = getShield();
		setShield(new Item());
		return ret;
	}
	public Item removeBackPack() {
		Item ret = getBackPack();
		setBackPack(new Item());
		return ret;
	}
	
	
	public void putHelmet(Item Helmet) {
		setHelmet(Helmet);
	}
	public void putChest(Item Chest) {
		setChest(Chest);
	}
	public void putGreave(Item Greave) {
		setGreave(Helmet);
	}
	public void putBoots(Item Boots) {
		setBoots(Helmet);
	}
	public void putShield(Item Shield) {
		setShield(Helmet);
	}
	public void putBackPack(Item bp) {
		setBackPack(bp);
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
		putShield(Chest);
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
		if (getHelmet()==null || getHelmet().getItemEnum()!=ItemEnum.EMPTY) {
			ret += "\nHelmet : "+getHelmet().toString();
		}else {
			ret += "\nHelmet : None";
		}
		
		if (getChest()==null || getChest().getItemEnum()!=ItemEnum.EMPTY) {
			ret += "\nChest : "+getChest().toString();
		}else {
			ret += "\nChest : None";
		}
		
		if (getGreave()==null || getGreave().getItemEnum()!=ItemEnum.EMPTY) {
			ret += "\nGreave : "+getGreave().toString();
		}else {
			ret += "\nGreave : None";
		}
		
		if (getBoots()==null || getBoots().getItemEnum()!=ItemEnum.EMPTY) {
			ret += "\nBoots : "+getBoots().toString();
		}else {
			ret += "\nBoots : None";
		}
		
		if (getShield()==null || getShield().getItemEnum()!=ItemEnum.EMPTY) {
			ret += "\nShield : "+getShield().toString();
		}else {
			ret += "\nShield : None";
		}
		if (getBackPack()==null || getBackPack().getItemEnum()!=ItemEnum.EMPTY) {
			ret += "\nBackPack : "+getBackPack().toString();
		}else {
			ret += "\nBackPack : None";
		}
		
		return ret;
		}
	
	
	
	
	
}
