package app.inventory;

import nonLiving.*;
import nonLiving.Item.ItemType;
import javafx.geometry.Insets;
import javafx.scene.control.Button;

public class InventorySlotView extends Button{

private SlotView slotView;
	
	public InventorySlotView(SlotInventory slot,ItemType TYPE) {
		super();
		
		getStylesheets().add(getClass().getResource("InventorySlotView.css").toExternalForm());
		
		slotView = new SlotView(slot,TYPE);
		
		setPadding(new Insets(0));
		setGraphic(slotView);

		
	}

}
