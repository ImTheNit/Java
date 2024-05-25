package app.inventory;

import nonLiving.Item.*;
import nonLiving.*;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class SlotView extends StackPane{

	private ImageView img;
	private Label label;
	private final String refPathItem = "images/item/";
	private final String refPathSlotArm ="images/slot/";
	public SlotView(SlotInventory slot,ItemType TYPE) {
		super();
		
		img = new ImageView();
		img.setFitHeight(48);
		img.setFitWidth(48);
		System.out.println(slot);
		System.out.println("test :\n"+getRefPathItem()+slot.getItem().getItemEnum().getTexture()+".png");
		System.out.println(getRefPathItem()+ItemEnum.EMPTY.getTexture()+".png");
		if (slot.getItem().getItemEnum() != ItemEnum.EMPTY) {
			System.out.println("testhelmet");
			img.setImage(new Image(getRefPathItem()+slot.getItem().getItemEnum().getTexture()+".png"));
			
		}
		else {
			switch(TYPE) {
			case HELMET:
				System.out.println("testhelmet");
				img.setImage(new Image(getRefPathSlotArm()+"HelmetSlot.png"));
				break;
			case CHEST:
				img.setImage(new Image(getRefPathSlotArm()+"ChestSlot.png"));
				break;
			case GREAVE:
				img.setImage(new Image(getRefPathSlotArm()+"GreaveSlot.png"));
				break;
			case BOOTS:
				img.setImage(new Image(getRefPathSlotArm()+"BootsSlot.png"));
				break;
			case SHIELD:
				img.setImage(new Image(getRefPathSlotArm()+"HelmetSlot.png"));
				break;
			case BACKPACK:
				img.setImage(new Image(getRefPathSlotArm()+"HelmetSlot.png"));
				break;
			default:
				img.setImage(new Image(getRefPathItem()+ItemEnum.EMPTY.getTexture()+".png"));
				break;
				
			}
		}	
		System.out.println("test");
		HBox labelPane = new HBox();
		labelPane.setAlignment(Pos.BOTTOM_RIGHT);
		
		label = new Label();
		label.setFont(new Font("Arial", 18));
		label.setTextFill(Color.WHITE);
		setQuantity(slot.getQuantity());
		labelPane.getChildren().add(label);
		
		getChildren().addAll(img, labelPane);
		/*
		slot.addEventHandler((oldSlot, newSlot) -> {
            if (newSlot.getItem() != null)
            	img.setImage(newSlot.getItem().getTexture());
            else
            	img.setImage(ItemEnum.noItemTexture);
            
            setQuantity(newSlot.getQuantity());
        });
		*/
		
		setBackground(new Background(new BackgroundFill(new Color(0, 0, 0, 0.5), null, null)));
		//ImageView imV = new ImageView(); 
		//setBackground(new Background(new BackgroundImage(new Image("images/player/player_down.png"),BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, null, null)));
	}

	
	
	public String getRefPathItem() {
		return refPathItem;
	}
	public String getRefPathSlotArm() {
		return refPathSlotArm;
	}
	void setQuantity(int quantity) {
		if (quantity == 0)
			label.setText("");
		else
			label.setText("" + quantity);
	}
}
