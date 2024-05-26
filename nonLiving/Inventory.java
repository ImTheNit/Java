package nonLiving;

import java.util.ArrayList;

import nonLiving.Item.Item;

public class Inventory {

	private int size;		// depends of items, augments ... not necessary, calcul from size of the arraylist
	private int baseSize;  // static size
	private ArrayList<SlotInventory> content;
	private int nbSlotUse;
	private int nextEmpty; // > size if full
	private ArmorInventory armorInventory ;
	//private SlotInventory hand;
	
	
	/*
	 * Constructors
	 */
	public Inventory(int size) {
		setBaseSize(size);
		setInventory();
		initArmorInventory();
		//setHand(new SlotInventory());
		
	}
	public Inventory() { // constructor light
		this(10);// default size
	}
	/*
	 * getter
	 */
	public int getSize() {
		return getContent().size();
	}
	public int getBaseSize() {
		return baseSize;
	}
	public ArrayList<SlotInventory> getContent() {
		return content;
	}
	public SlotInventory getContent(int index) {
		return content.get(index);
	}
	public int getNbSlotUse() {
		return nbSlotUse;
	}
	public int getNextEmpty() {
		return nextEmpty;
	}
	public ArmorInventory getArmorInventory() {
		return armorInventory;
	}
	/*public SlotInventory getHand() {
		return hand;
	}*/
	
	/*
	 * setter
	 */
	public void setSize(int size) {
		this.size = size;
	}
	public void setBaseSize(int size) {
		this.baseSize = size;
	}
	public void setContent(ArrayList<SlotInventory> content) {
		this.content = content;
	}
	public void setContent(int index,SlotInventory content) {
		this.content.set(index, content);
	}
	public void setNbSlotUse(int x) {
		nbSlotUse = x;
	}
	public void setNextEmpty(int x) {
		nextEmpty = x;
	}
	public void setArmorInventory(ArmorInventory x) {
		armorInventory = x;
	}
	/*public void setHand(SlotInventory s) {
		hand = s;
	}*/
	
	
	
	
	/*
	 * methods
	 */
	public void setInventory() {	//initialising to null
		//System.out.println("size:"+getSize());
		ArrayList<SlotInventory> Content = new ArrayList<SlotInventory>();
		SlotInventory NULL = new SlotInventory();
		for(int i=0;i<10;i++) {
			Content.add(NULL);
		}
		setContent(Content);
	}
	

	public void add(Item item, int index,int quantity) { 
		System.out.println("\nindex : "+index+"  quantity : "+quantity+"  size : "+getSize());
		if (index<getSize() && (getContent().get(index).isEmpty() || getContent().get(index).getItem().equals(item)) ) {
			if (item.getItemEnum().getStackMax()-getQuantity(index)>=quantity) {// enought space
				if(item.getItemEnum().getStackMax()-getQuantity(index)==quantity) {
					setContent(index,new SlotInventory(item,quantity,true));
				}else {
					setContent(index,new SlotInventory(item,quantity,false));
				}
				
				//getContent().get(index).setQuantity(quantity);
				
				System.out.println("Ajouté à l'index : "+index);
				//System.out.println("Inventorytest"+toString());
				for(int i = index+1;i<= getSize();i++) { // update nextEmpty attribute
					//System.out.println("\n"+getContent(index).toString());
					//System.out.println(getContent(index).isEmpty());
					if(!getContent().get(index).isEmpty()) {
						setNextEmpty(i);
						//System.out.println("NextEmpty:"+getNextEmpty());
						return;
					}
					
				}
				
			}
			else { //not enought space in the slot
				//System.out.println("TEST4");
				int removedq = item.getItemEnum().getStackMax() - getQuantity(index);
				add(item,index,removedq);
				int remainingq = quantity - removedq;
				//System.out.println("remaining"+remainingq);
				if ( nextAvailable(item) <= getSize()) {
					int index2 = nextAvailable(item);
					add(item,index2,remainingq);
					
				}else {
					return;
				}

			}
		}else {
			System.out.println("Impossible d'ajouter l'élément");
		}
		
	}
	
	
	public void addOne(Item item,int index) {
		add(item,index,1);
	}
	public void quickAdd(Item item,int quantity) {	// add to the first slot available //TODO
		//int q = item.getItemEnum().getStackMax()
		add(item,nextAvailable(item),quantity);
	}
	
	public SlotInventory getItem(int index) {
		if (index <= getSize()) {
			return getContent().get(index);
		}
		return null;
	}
	
	public int getQuantity(int index) { 
		if (index <= getSize()) {
			return getContent().get(index).getQuantity();
		}
		return 0;
	}
	
	public int getTotalQuantity(Item item) { 
		int sum = 0;
		for (int i = 0 ; i <=getSize();i++) {
			if (getContent().get(i).getItem()==item) {
				sum += getContent().get(i).getQuantity();
			}
		}
		return sum;
	}
	
	public SlotInventory remove(int index,int quantity) throws CloneNotSupportedException { 
		if (index<=getSize()) {
			SlotInventory ret =(SlotInventory) this.getContent(index).clone();
			if (ret.getQuantity()>quantity) {
				//System.out.println("test :"+(ret.getQuantity()-quantity));
				getContent(index).setQuantity(ret.getQuantity()-quantity);//put substraction
				ret.setQuantity(quantity);
				
			}else {
				getContent().get(index).setQuantity(0);
				if (index<getNextEmpty()) {		//update nextEmpty attribute
					setNextEmpty(index);
				}
				//System.out.println("quantity = "+getContent(index).getQuantity());
				if(getContent(index).getQuantity()==0) {
					setContent(index,new SlotInventory());
				}
			}
			return ret;
		}
		return null;
	}
	
	public SlotInventory removeOne (int index) throws CloneNotSupportedException {
		 return remove(index,1);
	}
	
	public SlotInventory removeAll(int index) throws CloneNotSupportedException {
		return remove(index,100);//arbitraire -> à remplacer par la valeur max possible
	}
	
	public int nextAvailable(Item item) {
		int ret = getNextEmpty();
		for (int i =0;i<getSize();i++) {
			
			if (item.equals(getContent(i).getItem()) && !getContent(i).getIsFull()) {// another same item found and not already full
				return i;
			}
		}
		
		
		return ret;
	}
	
	public void initArmorInventory() {
		setArmorInventory(new ArmorInventory());
	}
	
	public void increaseSize(int SIZE) {
		for (int i = 0; i<SIZE;i++) {
			getContent().add(new SlotInventory());
		}
	}
	
	public void decreaseSize(int SIZE) {
		int base_increase = getSize()-SIZE;
		boolean bool = true;
		System.out.println("\n\nbase_increase = "+base_increase+"SIZE = "+SIZE+"getSize()="+getSize());
		for (int i = base_increase;i<getSize();i++) {
			//System.out.println("test");
			if(!getContent(i).isEmpty()) {
				bool = false;
				System.out.println("Non-Empty slot found");
				break;
			}
		}
		if (bool) {
			System.out.println("All empty");
			ArrayList<SlotInventory> nouveau = new ArrayList<SlotInventory>();
			for (int i = 0;i<base_increase;i++) {
				//System.out.println(("test"+i));
				try {
					SlotInventory newSlot = getContent(i);
					nouveau.add(newSlot);
				}
				finally {
					
				}
				
				
			}
			setContent(nouveau);
		}
		
	}
	
	@Override
	public String toString() {
		String ret1 = "\nInventory :";
		String ret2 = "" ;
		String ret3 = getArmorInventory().toString();
		boolean b = true;
		for(int i = 0;i<getSize();i++) {
			if(!getContent(i).isEmpty()) {
				ret2 += "\nslot "+i+"\n"+getContent(i).toString();
				b = false;
			}
		}
		if (b) {
			ret2 += "\nInventaire Vide";

		}
		

		String ret = ret1 + ret2 +ret3 ;
		return ret;
	}
	
}
