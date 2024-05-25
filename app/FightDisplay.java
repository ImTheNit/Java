package app;


import living.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.image.* ;
import javafx.scene.input.KeyCode;


public class FightDisplay {

	
	
	/*
	 * generate gridpane with informations of fight
	 */
	public ImageView initDisplay(Player j1,Monster oponent) {
		
		double res = j1.fight(oponent);
		Image image;
		
		if (res<0) {
			image = new Image("images/fight/defeat.png");
		}else {
			image = new Image("images/fight/victory.png");
		}
		
		ImageView pic = new ImageView();
		pic.setImage(image);
		
		return pic;
	}
	
	/*
	 * generate empty gridpane
	 */
	public VBox initDisplay(ImageView pic) {
		GridPane gp = new GridPane();
		final VBox vbox = new VBox();
		vbox.setAlignment(Pos.CENTER);
		
		if( pic==null) {
			pic = new ImageView();
		}
		Image image = new Image("images/fight/defeat.png");
		pic.setImage(image);
		pic.setOpacity(0);
		
		gp.add(pic, 0, 0);
		gp.setAlignment(Pos.CENTER);
		vbox.getChildren().add(gp);
		return vbox;
		
	}
	
	
	
	
}
