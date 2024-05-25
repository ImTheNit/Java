package nonLiving.Item;


public enum ItemEnum {
	
	EMPTY("Empty item",ItemType.EMPTY,PassivEffect.NONE,ActivEffect.NONE,1,"EmptySlot"),
	
	NONE("Only for Displaying map correctly",ItemType.EMPTY,PassivEffect.NONE,ActivEffect.NONE,1,"Free1Day"),
	
	
	NORMAL_HELMET("normal helmet",ItemType.HELMET,PassivEffect.SMALL_INCREASE_LIFE,ActivEffect.NONE,1,"Helmet1.png"),
	LIFE_HELMET("life helmet",ItemType.HELMET,PassivEffect.MEDIUM_INCREASE_LIFE,ActivEffect.NONE,1,"HelmetLife.png"),
	ATK_HELMET("attack helmet",ItemType.HELMET,PassivEffect.MEDIUM_INCREASE_ATK,ActivEffect.NONE,1,"HelmetAtk.png"),
	DEF_HELMET("defence helmet",ItemType.HELMET,PassivEffect.MEDIUM_INCREASE_DEF,ActivEffect.NONE,1,"HelmetDef.png"),
	
	NORMAL_CHEST("normal chest",ItemType.CHEST,PassivEffect.SMALL_INCREASE_LIFE,ActivEffect.NONE,1,"Chest.png"),
	LIFE_CHEST("life chest",ItemType.CHEST,PassivEffect.MEDIUM_INCREASE_LIFE,ActivEffect.NONE,1,"ChestLife.png"),
	ATK_CHEST("attack chest",ItemType.CHEST,PassivEffect.MEDIUM_INCREASE_ATK,ActivEffect.NONE,1,"ChestAtk.png"),
	DEF_CHEST("defence chest",ItemType.CHEST,PassivEffect.MEDIUM_INCREASE_DEF,ActivEffect.NONE,1,"ChestDef.png"),
	
	NORMAL_GREAVE("normal greave",ItemType.GREAVE,PassivEffect.SMALL_INCREASE_LIFE,ActivEffect.NONE,1,"Greave.png"),
	LIFE_GREAVE("life greave",ItemType.GREAVE,PassivEffect.MEDIUM_INCREASE_LIFE,ActivEffect.NONE,1,"GreaveLife.png"),
	ATK_GREAVE("attack greave",ItemType.GREAVE,PassivEffect.MEDIUM_INCREASE_ATK,ActivEffect.NONE,1,"GreaveAtk.png"),
	DEF_GREAVE("defence greave",ItemType.GREAVE,PassivEffect.MEDIUM_INCREASE_DEF,ActivEffect.NONE,1,"GreaveDef.png"),
	
	NORMAL_BOOT("normal boots",ItemType.BOOTS,PassivEffect.SMALL_INCREASE_LIFE,ActivEffect.NONE,1,"Boots.png"),
	LIFE_BOOT("life boots",ItemType.BOOTS,PassivEffect.MEDIUM_INCREASE_LIFE,ActivEffect.NONE,1,"BootsLife.png"),
	ATK_BOOT("attack boots",ItemType.BOOTS,PassivEffect.MEDIUM_INCREASE_ATK,ActivEffect.NONE,1,"BootsAtk.png"),
	DEF_BOOT("defence boots",ItemType.BOOTS,PassivEffect.MEDIUM_INCREASE_DEF,ActivEffect.NONE,1,"BootsDef.png"),
	
	SMALL_SHIELD("small shield",ItemType.SHIELD,PassivEffect.SMALL_INCREASE_DEF,ActivEffect.NONE,1,"Shield.png"),
	MEDIUM_SHIELD("medium shield",ItemType.SHIELD,PassivEffect.MEDIUM_INCREASE_DEF,ActivEffect.NONE,1,"ShieldMedium.png"),
	BIG_SHIELD("big shield",ItemType.SHIELD,PassivEffect.BIG_INCREASE_DEF,ActivEffect.NONE,1,"ShieldBig.png"),
	
	SMALL_BACKPACK("small backpack",ItemType.BACKPACK,PassivEffect.SMALL_INCREASE_STORAGE,ActivEffect.NONE,1,"lien"),
	MEDIUM_BACKPACK("small backpack",ItemType.BACKPACK,PassivEffect.MEDIUM_INCREASE_STORAGE,ActivEffect.NONE,1,"lien"),
	BIG_BACKPACK("small backpack",ItemType.BACKPACK,PassivEffect.BIG_INCREASE_STORAGE,ActivEffect.NONE,1,"lien"),
	
	
	
	
	NORMAL_SWORD("normal sword",ItemType.SWORD,PassivEffect.SMALL_INCREASE_LIFE,ActivEffect.NONE,1,"lien"),
	LIFE_SWORD("life sword",ItemType.SWORD,PassivEffect.MEDIUM_INCREASE_LIFE,ActivEffect.NONE,1,"lien"),
	ATK_SWORD("attack sword",ItemType.SWORD,PassivEffect.MEDIUM_INCREASE_ATK,ActivEffect.NONE,1,"lien"),
	DEF_SWORD("defence sword",ItemType.SWORD,PassivEffect.MEDIUM_INCREASE_DEF,ActivEffect.NONE,1,"lien"),
	
	
	
	
	
	
	SMALL_LIFE_POTION("small life potion",ItemType.LIFE_POTION,PassivEffect.NONE,ActivEffect.SMALL_HEAL,5,"lien"),
	MEDIUM_LIFE_POTION("medium life potion",ItemType.LIFE_POTION,PassivEffect.NONE,ActivEffect.MEDIUM_HEAL,5,"lien"),
	BIG_LIFE_POTION("big life potion",ItemType.LIFE_POTION,PassivEffect.NONE,ActivEffect.BIG_HEAL,5,"lien")
	
	
	// A COMPLETER 
	;
	
	private String name;
	private ItemType type;
	private PassivEffect Peffect;
	private ActivEffect Aeffect;
	private int stackMax;
	private String texture;
	
	/*
	 * constructor
	 */
	ItemEnum(String Name,ItemType Type,PassivEffect pe,ActivEffect ae, int i, String texture) {
		setName(Name);
		setType(Type);
		setPeffect(pe);
		setAeffect(ae);
		setStackMax(i);
		setTexture(texture);
	}
	
	/*
	 * getter
	 */
	
	public String getName() {
		return name;
	}
	public ItemType getType() {
		return type;
	}
	public PassivEffect getPeffect() {
		return Peffect;
	}
	public ActivEffect getAeffect() {
		return Aeffect;
	}
	public int getStackMax() {
		return stackMax;
	}
	public String getTexture() {
		return texture;
	}
	
	
	/*
	 * setter
	 */
	
	public void setName(String Name) {
		name = Name;
	}
	public void setType(ItemType Type) {
		type = Type;
	}
	public void setPeffect(PassivEffect e) {
		Peffect = e;
	}
	public void setAeffect(ActivEffect e) {
		Aeffect = e;
	}
	public void setStackMax(int stack) {
		stackMax = stack;
	}
	public void setTexture(String Texture) {
		texture = Texture;
	}
	
	
	/*
	 * methods
	 */
	
	@Override
	public String toString() {
		String ret = "Name : "+getName();
		ret += getType().toString();
		ret += "\nPassiv Effect : "+getPeffect().toString();
		ret += "\nActiv Effect : "+getAeffect().toString();
		ret += "\nStackMax : "+getStackMax();
		ret += "\nTexture : "+getTexture();
		return ret;
	}
	
	
}
