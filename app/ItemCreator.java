package app;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

import elmt_Base.Direction;
import nonLiving.*;
import nonLiving.Item.DroppedItem;
import nonLiving.Item.Item;
import nonLiving.Item.ItemEnum;
import living.*;
import living.Sprites.*;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;



public class ItemCreator {

	// Load items from txt file
	
	private String[][] item;

	private DroppedItem[][] tabItem;
	
	
	
	/*
	 * Constructor
	 */
	
	public ItemCreator(String FileName,int numCols,int numRows) {
		this.item = new String[numCols][numRows];
		this.tabItem = new DroppedItem[numCols][numRows];
		System.out.println("ItemCreator initialised");
		System.out.println("numCols : "+numCols);
		System.out.println("numRows : "+numRows);
		
		
		try {
			System.out.println("items  from :"+FileName);
			loadItem(FileName);
			
		}catch(Exception e) {
			System.out.println("Error while charging items");
			e.printStackTrace();
		}
	}
	
	
	
	
	/*
	 * getter
	 */
	
	
	public String[][] getItem() {
		return item;
	}
	public String getItem(int x,int y) {
		return item[x][y];
	}
	public DroppedItem[][] getTabItem(){
		return tabItem;
	}
	public DroppedItem getTabItem(int x,int y) {
		return tabItem[x][y];
	}
	

	
	
	/*
	 * setter
	 */
	
	
	public void setItem(String[][] Item) {
		item = Item;
	}
	
	public void setItem(String Item,int x, int y) {
		item[x][y] = Item;
	}
	
	public void setTabItem(DroppedItem [][] ti) {
		tabItem = ti;
	}
	public void setTabItem(DroppedItem ti,int x,int y) {
		tabItem[x][y]=ti;
	}
	
	
	/*
	 * methods
	 */
	
	
	public void loadItem(String FileName) throws Exception{
		//FileReader file = new FileReader(FileName);
		//InputStreamReader file = new InputStreamReader(getClass().getResourceAsStream(FileName));
		System.out.println("../"+FileName);
		//System.out.println("test"+getClass().getResourceAsStream("../"+FileName));
		BufferedReader Br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("../"+FileName)));
		String Line;
		
		int i = 0;
		
		while((Line = Br.readLine())!=null) {
			System.out.println("Reading Line "+i+":"+Line);

			String[] split =Line.split("\t");//depending on the data format
			//System.out.println("length : "+split.length);
			for (int j = 0;j<split.length;j++) {//TODO améliorable pour ne prendre que 30 colonnes

				if(split[j].equals("Tree1Day")) {

					DroppedItem nle = new DroppedItem();
					setTabItem(nle,j,i);
					System.out.println("Setting up Items ["+i+"]["+j+"] to "+split[j]);
				}else {
					
					// setting up items
					DroppedItem nle = new DroppedItem(i,j,0,Direction.Up,new Item(),0);
					
					
					try {
						nle = new DroppedItem(i,j,0,Direction.Up,new Item(i+j,split[j],ItemEnum.valueOf(split[j]),1,1),1);
					}catch(Exception e) {
						System.out.println(e.getMessage());
						
					}finally {
						
						setTabItem(nle,j,i);
					}
				}
				setItem(split[j],j,i);
				System.out.println("Setting up Items ["+i+"]["+j+"] to "+split[j]);
				
			}
			i++;
		}
		Br.close();//end the reading
	}
	
	
	
	
	public GridPane initItem() {
		GridPane root = new GridPane();
		for(int i=0;i<getItem().length;i++) {
			for (int j =0;j<getItem()[i].length;j++) {
				if(getItem(i,j)!=null && getItem(i,j)!="") {
					
					
					StackPane sp = new StackPane();
					Image image;//= new Image("images/background/entities/Tree1.png");//tmp
					//System.out.println(getTabItem(i,j).getItem());
					//System.out.println("EXAMPLE"+getItem(i,j).equals("Tree1Day"));
					//System.out.println("EXAMPLE"+getItem(i,j));
					if (getItem(i,j).equals("Tree1Day")) {
						System.out.println("../images/background/entities/"+getItem(i, j)+".png");
						image= new Image(getClass().getResourceAsStream("../images/background/entities/"+getItem(i, j)+".png"));
					}else {
						System.out.println("../images/item/"+getTabItem(i,j).getItem().getItemEnum().getTexture()+".png");
						image= new Image(getClass().getResourceAsStream("../images/item/"+getTabItem(i,j).getItem().getItemEnum().getTexture()+".png"));
						getTabItem(i,j).setStackPane(sp);
					}
					

					
					
					ImageView pic = new ImageView();
					
					pic.setFitWidth(50);
					pic.setFitHeight(50);
					pic.setPreserveRatio(true);
					
					pic.setImage(image);
					pic.setOpacity(1);
					sp.getChildren().add(pic);
				

				
					root.add(sp, i, j);
				}
			}
		}
		return root;
	}
}
