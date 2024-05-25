package app.inventory;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.layout.VBox;
import nonLiving.Inventory;
import nonLiving.Item.ItemType;

public class InventoryView {

	private VBox inventoryVbox;
	
	
	
	
	
	
	/*
	 * getter
	 */
	
	
	public VBox getInventoryVbox() {
		return inventoryVbox;
	}
	
	
	/*
	 * setter
	 */
	
	
	
	public void setInventoryVbox(VBox v) {
		inventoryVbox = v;
	}
	public VBox initInventoryView(Inventory invent) {
		GridPane gpInv = new GridPane();
		GridPane gpArm = new GridPane();
		final VBox vbox = new VBox();
		vbox.setAlignment(Pos.BOTTOM_CENTER);
		
		
		//Inventory
		gpInv.setAlignment(Pos.BOTTOM_CENTER);
		for(int i=0;i<invent.getSize();i++) {
			InventorySlotView sv =new InventorySlotView(invent.getItem(i),invent.getItem(i).getItem().getItemEnum().getType());
			gpInv.add(sv, i%5, i/5);
		}
		gpInv.setVgap(5);
		gpInv.setHgap(7);
		
		// Armor
		
		gpArm.setAlignment(Pos.TOP_CENTER);
		gpArm.add(new InventorySlotView(invent.getArmorInventory().getHelmet(),ItemType.HELMET), 0, 0);
		gpArm.add(new InventorySlotView(invent.getArmorInventory().getChest(),ItemType.CHEST), 1/3, 1%3);
		gpArm.add(new InventorySlotView(invent.getArmorInventory().getGreave(),ItemType.GREAVE), 2/3, 2%3);
		gpArm.add(new InventorySlotView(invent.getArmorInventory().getBoots(),ItemType.BOOTS), 3/3, 3%3);
		gpArm.add(new InventorySlotView(invent.getArmorInventory().getShield(),ItemType.SHIELD), 4/3, 4%3);
		gpArm.add(new InventorySlotView(invent.getArmorInventory().getBackPack(),ItemType.BACKPACK), 5/3, 5%3);
		
		gpArm.setHgap(7);
		gpArm.setVgap(5);
		
		
		
		vbox.getChildren().add(gpArm);
		vbox.getChildren().add(gpInv);
		vbox.setSpacing(20);
		setInventoryVbox(vbox);
		return vbox;
		
	}
	
	
	
	
}
