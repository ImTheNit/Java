package living;

import elmt_Base.Direction;
import nonLiving.*;
import nonLiving.Item.DroppedItem;
import nonLiving.Item.Item;
import nonLiving.Item.ItemType;


public class LivingEntity extends Entity{

	private int level;
	private int xp;
	private int xpMax;
	private double life;
	private double maxLife;
	private double baseMaxLife;
	private double attack;
	private double baseAttack;
	private double defence;
	private double baseDefence;
	private Inventory inventory;
	private String name;
	
	/*
	 * constructor
	 */
	
	
	public LivingEntity(double x, double y, double weight,Direction Facing,int lev,int XP, int XPMax,double life,double atk,double def,String name) {
		super(x, y, weight,Facing);
		setLevel(lev);
		setXp(XP);
		setXpMax(XPMax);
		setLife(life);
		setBaseMaxLife(life);
		setMaxLife(life);
		setAtk(atk);
		setBaseAtk(atk);
		setDef(def);
		setBaseDef(def);
		setName(name);
		Inventory I = new Inventory();
		setInventory(I);
	}
	// Ajouter constructeur pour cas où moins de paramètres
	public LivingEntity(double x, double y, double weight,Direction Facing,double life,double atk,double def,String name) {  // constructor light
		this(x,y,weight,Facing,1,0,100,life,atk,def,name); //appel du constructeur
	}

	/*
	 * getter
	 */
	public int getLevel() {
		return level;
	}
	public int getXp() {
		return xp;
	}
	public int getXpMax() {
		return xpMax;
	}
	public double getLife() {
		return life;
	}
	public double getMaxLife() {
		return maxLife;
	}
	public double getBaseMaxLife() {
		return baseMaxLife;
	}
	public double getAtk() {
		return attack;
	}
	public double getBaseAtk() {
		return baseAttack;
	}
	public double getDef() {
		return defence;
	}
	public double getBaseDef() {
		return baseDefence;
	}
	public Inventory getInventory() {
		return inventory;
	}
	public String getName() {
		return name;
	}
	/*
	 * setter
	 */
	
	public void setLevel(int x) {
		level = x;
	}
	public void setXp(int x) {
		xp = x;
	}
	public void setXp() {
		setXp(0);
	}
	public void setXpMax(int x) {
		xpMax = x;
	}
	
	public void setLife(double x) {
		life=x;
	}
	public void setMaxLife(double x) {
		maxLife=x;
	}
	public void setBaseMaxLife(double x) {
		baseMaxLife=x;
	}
	
	public void setAtk(double x) {
		attack=x;
	}
	public void setBaseAtk(double x) {
		baseAttack=x;
	}
	
	public void setDef(double x) {
		defence=x;
	}
	public void setBaseDef(double x) {
		baseDefence=x;
	}
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	public void setInventory() {
		this.inventory = new Inventory();
	}
	public void setName(String s) {
		name=s;
	}
	
	
	
	/*
	 * methods 
	 */
	public void gainLevel() {
		setLevel(getLevel()+1) ;
		setXp(0);
		//ajustement de stats ?
	}
	public void gainXp(int x) {
		if (getXp() + x < getXpMax()) {
			setXp(getXp()+x) ;
		}
		else {
			int diff = getXpMax()-getXp();
			gainLevel();
			gainXp(x-diff);
		}
	}
	public void looseLife(double x) {
		setLife(getLife()-x);
		if (getLife()<=0) {
			// effet a la mort ? commun pour monstre et Joueurs
		}
	}
	public void changeLifeFlat(double x) {
		setLife(getBaseMaxLife()-x) ;
	}
	public void increaseLife(double x) {
		setLife(getBaseMaxLife()*(1+x));
	}
	public void decreaseLife(double x) {
		setLife(getBaseMaxLife()*(1-x)) ;
	}
	
	
	
	public void changeMaxLifeFlat(double x) {
		setMaxLife(getMaxLife()+x);
	}
	public void increaseMaxLife(double x) {
		setMaxLife(getMaxLife()*(1+x));
	}
	public void decreaseMaxLife(double x) {
		setMaxLife(getMaxLife()*(1-x));
	}
	
	
	
	public void changeBasMaxLifeFlat(double x) {
		setBaseMaxLife(getBaseMaxLife()+x);
	}
	public void increaseBaseMaxLife(double x) {
		setBaseMaxLife(getBaseMaxLife()*(1+x));
	}
	public void decreaseBaseMaxLife(double x) {
		setBaseMaxLife(getBaseMaxLife()*(1-x));
	}
	
	
	
	public void changeAtkFlat(double x) {
		setAtk(getAtk()+x);
	}
	public void increaseAtk(double x) {
		setAtk(getAtk()*(1+x));
	}
	public void decreaseAtk(double x) {
		setAtk(getAtk()*(1-x));
	}

	
	public void changeBaseAtkFlat(double x) {
		setBaseAtk(getBaseAtk()+x);
	}
	public void increaseBaseAtk(double x) {
		setBaseAtk(getBaseAtk()*(1+x));
	}
	public void decreaseBaseAtk(double x) {
		setBaseAtk(getBaseAtk()*(1-x));
	}
	
	
	
	public void changeDefFlat(double x) {
		setDef(getDef()+x);
	}
	public void increaseDef(double x) {
		setDef(getDef()*(1+x));
	}
	public void decreaseDef(double x) {
		setDef(getDef()*(1-x));
	}
	
	
	public void changeBaseDefFlat(double x) {
		setBaseDef(getBaseDef()+x);
	}
	public void increaseBaseDef(double x) {
		setBaseDef(getBaseDef()*(1+x));
	}
	public void decreaseBaseDef(double x) {
		setBaseDef(getBaseDef()*(1-x));
	}
	
	
	
	
	
	
	
	public void hit(LivingEntity target) {
		double damage ;
		if (target.getDef()<=1) {		// not supposed to happend
			damage = getAtk() * 2;
		}else {
			damage = getAtk() * Math.log(target.getDef());
		}
		target.looseLife(damage);
		
		
		String ret = "\n//Attacker// :\n";	// control display
		ret += this.toString();
		
		ret += "\n\n//Defencer//\n";
		ret += target.toString();
		
		ret += "\ndamage : "+damage;
		System.out.println(ret);
	}
	
	
	
	public void pickItem(DroppedItem ditem) { //to purchase
		if (getInventory().getNextEmpty() > getInventory().getSize()) { // full
			// check no not full slot
			if(getInventory().nextAvailable(ditem.getItem())==getInventory().getNextEmpty()) { // the next available slot is already the nextEmpty slot
				System.out.println("\n\nInventaire plein, impossible de ramasser "+ditem.getItem().getName()+"("+ditem.getQuantity()+")");	
				return;
			}
			else { //slot not full find
				 getInventory().add(ditem.getItem(), getInventory().nextAvailable(ditem.getItem()),ditem.getQuantity());
				 System.out.println("test2");
				 return;
			}
			
		}else { // No full
			getInventory().add(ditem.getItem(),getInventory().getNextEmpty(), ditem.getQuantity());
			//System.out.println("test3");
			//System.out.println("test"+getInventory().getNextEmpty());
			//System.out.println(getInventory().toString());
			
			return;
		}
	}
	public DroppedItem dropItem(int index,int quantity) throws CloneNotSupportedException {
		SlotInventory slot = getInventory().remove(index, quantity);
		return new DroppedItem(slot.getItem(),slot.getQuantity());
	}
	
	public SlotInventory wear(SlotInventory Slotitem) { //return the old equipment
		Item i;
		switch(Slotitem.getItem().getItemEnum().getType()) {
		case HELMET :
			i = getInventory().getArmorInventory().replaceHelmet(Slotitem.getItem());
			break;
		case CHEST :
			i = getInventory().getArmorInventory().replaceChest(Slotitem.getItem());
			break;
		case GREAVE:
			i = getInventory().getArmorInventory().replaceGreave(Slotitem.getItem());
			break;
		case BOOTS:
			i = getInventory().getArmorInventory().replaceBoots(Slotitem.getItem());
			break;
		case SHIELD:
			i = getInventory().getArmorInventory().replaceShield(Slotitem.getItem());
			break;
		case BACKPACK:
			i = getInventory().getArmorInventory().replaceBackPack(Slotitem.getItem());
			break;
		default:
			System.out.println("Type incorrect pour equipement");
			return new SlotInventory();//empty slot
			
		}
		i.endPassiv(this);
		Slotitem.getItem().initPassiv(this);
		return new SlotInventory(i,1,true);
	}
	
	
	@Override
	public String toString() {
		String ret = "Name:"+getName() ;
		ret += "\nLevel :"+getLevel();
		ret += "\nXp : "+getXp();
		ret += "\nXpMax :"+getXpMax();
		ret += "\nlife:"+getLife();
		ret += "\nMaxLife:"+getMaxLife();
		ret += "\nAtk:"+getAtk();
		ret += "\nDef:"+getDef();
		return ret+super.toString();		
	}
	
}
