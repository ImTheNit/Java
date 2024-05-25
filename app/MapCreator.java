package app;

import java.io.*;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class MapCreator {

	// Load map from txt file
	
	private String[][] map;
	private final String refMap = "images/background/map/";
	
	
	/*
	 * constructor
	 */
	
	public MapCreator(String FileName,int numCols,int numRows) {
		this.map = new String[numCols][numRows];
		System.out.println("MapCreator initialised");
		System.out.println("numCols : "+numCols);
		System.out.println("numRows : "+numRows);
		
		
		try {
			System.out.println("Charging map from :"+FileName);
			loadMap(FileName);
			
		}catch(Exception e) {
			System.out.println("Error while charging map");
			e.printStackTrace();
		}
	}
	
	
	/*
	 * getter
	 */
	
	public String[][] getMap() {
		return map;
	}
	public String getMap(int x,int y) {
		return map[x][y];
	}
	
	public String getRefMap() {
		return refMap;
	}
	
	/*
	 * setter
	 */
	
	
	public void setMap(String[][] Map) {
		map = Map;
	}
	
	public void setMap(String Map,int x, int y) {
		map[x][y] = Map;
	}
	
	/*
	 * methods
	 */
	
	
	public void loadMap(String FileName) throws Exception{
		FileReader file = new FileReader(FileName);
		BufferedReader Br = new BufferedReader(file);
		String Line;
		
		int i = 0;
		
		while((Line = Br.readLine())!=null) {
			System.out.println("Reading Line "+i+":"+Line);

			String[] split =Line.split("\t");//depending on the data format
			System.out.println("length : "+split.length);
			for (int j = 0;j<split.length;j++) {
				setMap(split[j],j,i);
				System.out.println("Setting up the map ["+i+"]["+j+"] to "+split[j]);
			}
			i++;
		}
		Br.close();//end the reading
	}
	
	
	
	
	public GridPane initMap() {
		GridPane root = new GridPane();
		for(int i=0;i<getMap().length;i++) {
			for (int j =0;j<getMap()[i].length;j++) {
				StackPane sp = new StackPane();
				//System.out.println("contenu "+i+";"+j+" : "+map.getMap(i, j));
				
				Image image= new Image(getRefMap()+getMap(i, j)+".png");
				ImageView pic = new ImageView();
				
				pic.setFitWidth(50);
				pic.setFitHeight(50);
				pic.setPreserveRatio(true);
				
				pic.setImage(image);
				
				sp.getChildren().add(pic);
				
				
				//TEST add player icon
				//ImageView pic2 = new ImageView();
				//pic2.setImage(new Image(joueur.sprite()));
				//sp.getChildren().add(pic2);
				
				
				root.add(sp, i, j);
			}
		}
		return root;
	}
	
	
	
	
	
	
	
	
	
	
	
}
