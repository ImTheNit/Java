package nonLiving.Item;

public enum ItemType {
	
	EMPTY(ItemGroup.EMPTY),
	
	HELMET(ItemGroup.EQUIPMENT),
	BOOTS(ItemGroup.EQUIPMENT),
	CHEST(ItemGroup.EQUIPMENT),
	GREAVE(ItemGroup.EQUIPMENT),
	SHIELD(ItemGroup.EQUIPMENT),
	BACKPACK(ItemGroup.EQUIPMENT),
	
	SWORD(ItemGroup.TOOL),
	PICKAXE(ItemGroup.TOOL),
	AXE(ItemGroup.TOOL),
	
	LIFE_POTION(ItemGroup.CONSUMABLE)
	
	
	// A COMPLETER
	
	;
	
	private ItemGroup group;
	/*
	 * Constructor
	 */

	ItemType(ItemGroup groupname) {
		setGroup(groupname);
	}
	
	/*
	 * getter
	 */
	
	public ItemGroup getGroup() {
		return group;
	}
	
	/*
	 * setter
	 */

	public void setGroup(ItemGroup groupname) {
		group = groupname;
	}
	
	/*
	 * Methods
	 */
	
	
	@Override
	public String toString() {
		String ret = "\nType : "+name();
		ret += getGroup().toString();
		return ret;
	}
}
