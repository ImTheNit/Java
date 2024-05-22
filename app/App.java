package app;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.image.* ;


public class App extends Application{

	@Override
	public void start(Stage arg0) throws Exception {
		
		
		GridPane Gp = new GridPane();
		/*for (int i =0 ;i<10;i++) {
			Gp.add(new Button("Test"+i),i%5,i/5);
		}*/
		
		
		Scene scene = new Scene(Gp,1920,1080);
		Image image1= new Image("File:Axe.png");
		
		arg0.setTitle("LevelOne");
		arg0.setScene(scene);
		arg0.show();
		Gp.add(new ImageView(image1),0,0);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	

}
