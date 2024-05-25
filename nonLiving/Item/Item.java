package nonLiving.Item;

import living.LivingEntity;
import nonLiving.Item.ItemEnum;

public class Item  {

	private int id;
	private String name;
	private  ItemEnum itemenum;
	private int durability;
	private int durabilityMax;
	
	
	/*
	 * Constructor
	 */
	public Item(int Id,String Name,ItemEnum i, int Dura,int DuraMax) {
		setId(Id);
		setName(Name);
		setItemEnum(i);
		setDurability(Dura);
		setDurabilityMax(DuraMax);
		
	}
	public Item() { // constructor of EMPTY element
		this(0,"empty",ItemEnum.EMPTY,1,1);
	}
	public Item (ItemEnum i) {
		this(0,"none",i,1,1);
	}

	
	/*
	 * getter
	 */
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public ItemEnum getItemEnum() {
		return itemenum;
	}
	public int getDurability() {
		return durability;
	}
	public int getDurabilityMax() {
		return durabilityMax;
	}
	
	
	
	/*
	 * setter
	 */
	public void setId(int x) {
		id = x;
	}
	public void setName(String s) {
		name = s;
	}
	public void setItemEnum(ItemEnum i) {
		itemenum = i;
	}
	public void setDurability(int x) {
		durability = x;
	}
	public void setDurabilityMax(int x) {
		durabilityMax	 = x;
	}
	
	/*
	 * methods
	 */
	
	public void repair(int x) {
		setDurability(getDurability()+x);
	}
	public void repair() {
		repair(1);
	}
	public void useDurability(int x ) {
		setDurability(getDurability()-x);
	}
	public void useDurability() {
		useDurability(1);
	}
	
	public void editDurabilityMaxFlat(int x) {
		setDurabilityMax(getDurabilityMax()+x);
	}
	public void editDurabilityMax(double ratio) {
		if (ratio != 0) {
			setDurabilityMax((int)ratio *getDurabilityMax());
		}
	}
	
	public void use(LivingEntity target) {
		switch(getItemEnum().getAeffect()) {
		case NONE:
			// no action
			break;
		case SMALL_HEAL:
			//
			break;
		case MEDIUM_HEAL:
			//
			break;
		case BIG_HEAL:
			//
			break;
		default:
			System.out.println("Unkown Activ Effect");
		}
	}
	
	public void initPassiv(LivingEntity target) {
		switch(getItemEnum().getPeffect()) {
		
		case NONE:
			//no action
		case SMALL_INCREASE_LIFE:
			target.changeMaxLifeFlat(getItemEnum().getPeffect().getValue());
			break;
		case MEDIUM_INCREASE_LIFE:
			target.changeMaxLifeFlat(getItemEnum().getPeffect().getValue());
			break;
		case BIG_INCREASE_LIFE:
			target.changeMaxLifeFlat(getItemEnum().getPeffect().getValue());
			break;
			
		case SMALL_DECREASE_LIFE:
			target.changeMaxLifeFlat(-(getItemEnum().getPeffect().getValue()));
			break;
		case MEDIUM_DECREASE_LIFE:
			target.changeMaxLifeFlat(-(getItemEnum().getPeffect().getValue()));
			break;
		case BIG_DECREASE_LIFE:	
			target.changeMaxLifeFlat(-(getItemEnum().getPeffect().getValue()));
			break;
			
			
		case SMALL_INCREASE_ATK:
			target.changeAtkFlat(getItemEnum().getPeffect().getValue());
			break;
		case MEDIUM_INCREASE_ATK:
			target.changeAtkFlat(getItemEnum().getPeffect().getValue());
			break;
		case BIG_INCREASE_ATK:
			target.changeAtkFlat(getItemEnum().getPeffect().getValue());
			break;
		
		case SMALL_DECREASE_ATK:
			target.changeAtkFlat(-(getItemEnum().getPeffect().getValue()));
			break;
		case MEDIUM_DECREASE_ATK:
			target.changeAtkFlat(-(getItemEnum().getPeffect().getValue()));
			break;
		case BIG_DECREASE_ATK:
			target.changeAtkFlat(-(getItemEnum().getPeffect().getValue()));
			break;
			
		
		case SMALL_INCREASE_DEF:
			target.changeDefFlat(getItemEnum().getPeffect().getValue());
			break;
		case MEDIUM_INCREASE_DEF:
			target.changeDefFlat(getItemEnum().getPeffect().getValue());
			break;
		case BIG_INCREASE_DEF:
			target.changeDefFlat(getItemEnum().getPeffect().getValue());
			break;
		
		case SMALL_DECREASE_DEF:
			target.changeDefFlat(-(getItemEnum().getPeffect().getValue()));
			break;
		case MEDIUM_DECREASE_DEF:
			target.changeDefFlat(-(getItemEnum().getPeffect().getValue()));
			break;
		case BIG_DECREASE_DEF:
			target.changeDefFlat(-(getItemEnum().getPeffect().getValue()));
			break;
			
			
			
		case SMALL_INCREASE_STORAGE:
			target.getInventory().increaseSize(getItemEnum().getPeffect().getValue());
			break;
		case MEDIUM_INCREASE_STORAGE:
			target.getInventory().increaseSize(getItemEnum().getPeffect().getValue());
			break;
		case BIG_INCREASE_STORAGE:
			target.getInventory().increaseSize(getItemEnum().getPeffect().getValue());
			break;
			
		case SMALL_DECREASE_STORAGE:
			target.getInventory().decreaseSize(getItemEnum().getPeffect().getValue());
			break;
		case MEDIUM_DECREASE_STORAGE:
			target.getInventory().decreaseSize(getItemEnum().getPeffect().getValue());
			break;
		case BIG_DECREASE_STORAGE:
			target.getInventory().decreaseSize(getItemEnum().getPeffect().getValue());
			break;
			
			
			
			
		default : 
			System.out.println("Unkown Passiv Effect"+getItemEnum().getPeffect().toString());
		}
	}
	
	public void endPassiv(LivingEntity target) {

		switch(getItemEnum().getPeffect()) {
		
		case NONE:
			//no action
		case SMALL_INCREASE_LIFE:
			target.changeMaxLifeFlat(-(getItemEnum().getPeffect().getValue()));
			break;
		case MEDIUM_INCREASE_LIFE:
			target.changeMaxLifeFlat(-(getItemEnum().getPeffect().getValue()));
			break;
		case BIG_INCREASE_LIFE:
			target.changeMaxLifeFlat(-(getItemEnum().getPeffect().getValue()));
			break;
			
		case SMALL_DECREASE_LIFE:
			target.changeMaxLifeFlat((getItemEnum().getPeffect().getValue()));
			break;
		case MEDIUM_DECREASE_LIFE:
			target.changeMaxLifeFlat((getItemEnum().getPeffect().getValue()));
			break;
		case BIG_DECREASE_LIFE:	
			target.changeMaxLifeFlat((getItemEnum().getPeffect().getValue()));
			break;
			
			
		case SMALL_INCREASE_ATK:
			target.changeAtkFlat(-(getItemEnum().getPeffect().getValue()));
			break;
		case MEDIUM_INCREASE_ATK:
			target.changeAtkFlat(-(getItemEnum().getPeffect().getValue()));
			break;
		case BIG_INCREASE_ATK:
			target.changeAtkFlat(-(getItemEnum().getPeffect().getValue()));
			break;
		
		case SMALL_DECREASE_ATK:
			target.changeAtkFlat((getItemEnum().getPeffect().getValue()));
			break;
		case MEDIUM_DECREASE_ATK:
			target.changeAtkFlat((getItemEnum().getPeffect().getValue()));
			break;
		case BIG_DECREASE_ATK:
			target.changeAtkFlat((getItemEnum().getPeffect().getValue()));
			break;
			
		
		case SMALL_INCREASE_DEF:
			target.changeDefFlat(-(getItemEnum().getPeffect().getValue()));
			break;
		case MEDIUM_INCREASE_DEF:
			target.changeDefFlat(-(getItemEnum().getPeffect().getValue()));
			break;
		case BIG_INCREASE_DEF:
			target.changeDefFlat(-(getItemEnum().getPeffect().getValue()));
			break;
		
		case SMALL_DECREASE_DEF:
			target.changeDefFlat((getItemEnum().getPeffect().getValue()));
			break;
		case MEDIUM_DECREASE_DEF:
			target.changeDefFlat((getItemEnum().getPeffect().getValue()));
			break;
		case BIG_DECREASE_DEF:
			target.changeDefFlat((getItemEnum().getPeffect().getValue()));
			break;
			
			
		
		case SMALL_INCREASE_STORAGE:
			target.getInventory().decreaseSize(getItemEnum().getPeffect().getValue());
			break;
		case MEDIUM_INCREASE_STORAGE:
			target.getInventory().decreaseSize(getItemEnum().getPeffect().getValue());
			break;
		case BIG_INCREASE_STORAGE:
			target.getInventory().decreaseSize(getItemEnum().getPeffect().getValue());
			break;
			
		case SMALL_DECREASE_STORAGE:
			target.getInventory().increaseSize(getItemEnum().getPeffect().getValue());
			break;
		case MEDIUM_DECREASE_STORAGE:
			target.getInventory().increaseSize(getItemEnum().getPeffect().getValue());
			break;
		case BIG_DECREASE_STORAGE:
			target.getInventory().increaseSize(getItemEnum().getPeffect().getValue());
			break;
			
			
		default : 
			System.out.println("Unkown Passiv Effect"+getItemEnum().getPeffect().toString());
		}
	}
	
	
	
	/*
	 * EQUALS A FAIRE IMPERATIVEMENT 
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof Item) {
			Item item = (Item) o;
			return item.getItemEnum()==getItemEnum();		// return true if the same type of item, not link with durability/name/etc...
		}
		return false;
	}
	
	@Override
	public String toString() {
		String ret = "\nid:"+getId();
		ret += "\nname : "+getName();
		ret += "\nitemEnum : "+getItemEnum().toString();
		ret += "\ndurability : "+getDurability();
		ret += "\ndurabilityMax : "+getDurabilityMax();
		return ret;				
	}
	
}

