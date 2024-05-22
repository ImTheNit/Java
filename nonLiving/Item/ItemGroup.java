package nonLiving.Item;

public enum ItemGroup {
	EMPTY,
	EQUIPMENT,
	TOOL,
	CONSUMABLE,
	RESSOURCE;
	
	
	
	
	
	
	/*
	 * Methods
	 */
	
	
	@Override
	public String toString() {
		String ret = "\nGroup : " +name();
		return ret;
	}
}
