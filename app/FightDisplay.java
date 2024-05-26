package app;


import living.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
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
			image = new Image(getClass().getResourceAsStream("../images/fight/defeat.png"));
		}else {
			image = new Image(getClass().getResourceAsStream("../images/fight/victory.png"));
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
		vbox.setAlignment(Pos.TOP_CENTER);
		//ajout bouton plus de détails sur le combat
		if( pic==null) {
			pic = new ImageView();
		}
		Image image = new Image(getClass().getResourceAsStream("../images/fight/defeat.png"));
		
		pic.setImage(image);
		pic.setOpacity(0);
		
		gp.add(pic, 0, 0);
		gp.setAlignment(Pos.BOTTOM_CENTER);
		//vbox.setPadding(new Insets(20));
		//vbox.setSpacing(20);
		vbox.setStyle("-fx-padding:50px;");
		vbox.getChildren().add(gp);
		return vbox;
		
	}
	
	
	
	
}
