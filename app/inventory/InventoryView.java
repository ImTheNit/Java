package app.inventory;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.layout.VBox;
import nonLiving.Inventory;
import nonLiving.SlotInventory;
import nonLiving.Item.ItemType;

public class InventoryView {

	private VBox inventoryVbox;
	private GridPane gpInv;
	private GridPane gpArm;
	private GridPane gpHand;
	private SlotInventory hand;
	private int HandItemSlotOrigin;
	
	
	
	
	/*
	 * getter
	 */
	
	
	public VBox getInventoryVbox() {
		return inventoryVbox;
	}
	public GridPane getGpInv() {
		return gpInv;
	}
	public GridPane getGpArm() {
		return gpArm;
	}
	public GridPane getGpHand() {
		return gpHand;
	}
	public SlotInventory getHand() {
		return hand;
	}
	public int getHandItemSlotOrigin() {
		return HandItemSlotOrigin;
	}
	
	
	/*
	 * setter
	 */
	
	
	
	public void setInventoryVbox(VBox v) {
		inventoryVbox = v;
	}
	public void setGpInv(GridPane gp) {
		gpInv = gp;
	}
	public void setGpArm(GridPane gp) {
		gpArm = gp;
	}
	public void setGpHand(GridPane gp) {
		gpHand = gp;
	}
	public void setHand(SlotInventory s) {
		hand = s;
	}
	public void setHandItemSlotOrignin(int i) {
		HandItemSlotOrigin = i;
	}
	
	
	
	/*
	 * methods
	 */
	public void initInventoryView(Inventory invent) {
		setHand(new SlotInventory());
	
		//setHantItemSlotOrigin(null);
		GridPane gpInv = new GridPane();
		GridPane gpArm = new GridPane();
		GridPane gpHand = new GridPane();
		final VBox vbox = new VBox();
		vbox.setAlignment(Pos.BOTTOM_CENTER);
		
		
		//Inventory
		gpInv.setAlignment(Pos.BOTTOM_CENTER);
		for(int i=0;i<invent.getSize();i++) {
			SlotInventory sI = invent.getItem(i);
			InventorySlotView sv =new InventorySlotView(sI,invent.getItem(i).getItem().getItemEnum().getType());
			sv.setOnAction(event -> {
				//System.out.println("test appel");
				handleSlotClick(invent,sI,0);
			});
			gpInv.add(sv, i%5, i/5);
		}
		gpInv.setVgap(5);
		gpInv.setHgap(7);
		
		// Armor
		
		gpArm.setAlignment(Pos.TOP_CENTER);
		InventorySlotView slotHelmet = new InventorySlotView(invent.getArmorInventory().getHelmet(),ItemType.HELMET);
		InventorySlotView slotChest = new InventorySlotView(invent.getArmorInventory().getChest(),ItemType.CHEST);
		InventorySlotView slotGreave = new InventorySlotView(invent.getArmorInventory().getGreave(),ItemType.GREAVE);
		InventorySlotView slotBoots = new InventorySlotView(invent.getArmorInventory().getBoots(),ItemType.BOOTS);
		InventorySlotView slotShield = new InventorySlotView(invent.getArmorInventory().getShield(),ItemType.SHIELD);
		InventorySlotView slotBackPack = new InventorySlotView(invent.getArmorInventory().getBackPack(),ItemType.BACKPACK);
		
		
		slotHelmet.setOnAction(event -> {
			//System.out.println("test appel");
			handleSlotClick(invent,invent.getArmorInventory().getHelmet(),0);
		});
		slotChest.setOnAction(event -> {
			//System.out.println("test appel");
			handleSlotClick(invent,invent.getArmorInventory().getHelmet(),0);
		});
		slotGreave.setOnAction(event -> {
			//System.out.println("test appel");
			handleSlotClick(invent,invent.getArmorInventory().getHelmet(),0);
		});
		slotBoots.setOnAction(event -> {
			//System.out.println("test appel");
			handleSlotClick(invent,invent.getArmorInventory().getHelmet(),0);
		});
		slotShield.setOnAction(event -> {
			//System.out.println("test appel");
			handleSlotClick(invent,invent.getArmorInventory().getHelmet(),0);
		});
		
		slotBackPack.setOnAction(event -> {
			//System.out.println("test appel");
			handleSlotClick(invent,invent.getArmorInventory().getHelmet(),0);
		});
		
		
		gpArm.add(slotHelmet, 0, 0);
		gpArm.add(slotChest, 1/3, 1%3);
		gpArm.add(slotGreave, 2/3, 2%3);
		gpArm.add(slotBoots, 3/3, 3%3);
		gpArm.add(slotShield, 4/3, 4%3);
		gpArm.add(slotBackPack, 5/3, 5%3);
		
		gpArm.setHgap(7);
		gpArm.setVgap(5);
		
		
		// Hand 
		InventorySlotView slotHand = new InventorySlotView(new SlotInventory(),ItemType.EMPTY);
		slotHand.setOnAction(event -> {
			//System.out.println("test appel");
			handleSlotClick(invent,invent.getArmorInventory().getHelmet(),0);
		});
		gpHand.add(slotHand, 0, 0);
		gpHand.setAlignment(Pos.TOP_CENTER);
		
		
		
		// adding all to the grid
		vbox.getChildren().add(gpHand);
		vbox.getChildren().add(gpArm);
		vbox.getChildren().add(gpInv);
		
		vbox.setSpacing(20);
		vbox.setOpacity(0);
		setInventoryVbox(vbox);
		//return vbox;
		
	}
	private void handleSlotClick(Inventory invent, SlotInventory slot,int slotPosition) {
		System.out.println("TEST");
		if (slot.isEmpty() && !hand.isEmpty()) {
			System.out.println("TEST1");
			//From Hand to slot
			slot.setItem(hand.getItem());
			slot.setQuantity(hand.getQuantity());
			slot.setIsFull(hand.getIsFull());
			
		}else if (!slot.isEmpty() && hand.isEmpty()){
			System.out.println("TEST2");
			//From slot to Hand
			hand.setItem(slot.getItem());
			hand.setQuantity(slot.getQuantity());
			hand.setIsFull(slot.getIsFull());
			
		}else if (!slot.isEmpty() && !hand.isEmpty()) {
			System.out.println("TEST3");
			//Both not empty
			
			if (slot.getItem().getId() == hand.getItem().getId()) {		// a verifier, utiliser les itemEnum si l'id ne marche pas
				System.out.println("TEST4");
				//Same item
				int toMove = Math.min(slot.getItem().getItemEnum().getStackMax()-slot.getQuantity(), hand.getQuantity());
				invent.add(slot.getItem(), slotPosition, toMove);
				
			}else {
				System.out.println("TEST5");
				//Swap
				SlotInventory tmp = slot;
				
				hand.setItem(slot.getItem());
				hand.setQuantity(slot.getQuantity());
				hand.setIsFull(slot.getIsFull());
				
				slot.setItem(hand.getItem());
				slot.setQuantity(hand.getQuantity());
				slot.setIsFull(hand.getIsFull());
				
				
				
			}
			System.out.println("TEST6");
		}/*
		if (!hand.isEmpty() && handItemSlot)
		*/
		
		System.out.println("test de fin ");
	}
	
	
	public VBox updateInventoryView(Inventory invent) {
		//getInventoryVbox().getChildren().clear();
		initInventoryView(invent);
		return getInventoryVbox();
	}
	
	
	
	
}
