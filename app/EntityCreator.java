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

public class EntityCreator {

	// Load entity from txt file
	
	private String[][] entity;

	private Entity[][] tabEntity;
	
	
	/*
	 * constructor
	 */
	
	public EntityCreator(String FileName,int numCols,int numRows) {
		this.entity = new String[numCols][numRows];
		this.tabEntity = new Entity[numCols][numRows];
		System.out.println("EntityCreator initialised");
		System.out.println("numCols : "+numCols);
		System.out.println("numRows : "+numRows);
		
		
		try {
			System.out.println("entities entities from :"+FileName);
			loadEntity(FileName);
			
		}catch(Exception e) {
			System.out.println("Error while charging entities");
			e.printStackTrace();
		}
	}
	
	
	/*
	 * getter
	 */
	
	public String[][] getEntity() {
		return entity;
	}
	public String getEntity(int x,int y) {
		return entity[x][y];
	}
	public Entity[][] getTabEntity(){
		return tabEntity;
	}
	public Entity getTabEntity(int x,int y) {
		return tabEntity[x][y];
	}
	
	/*
	 * setter
	 */
	
	
	public void setEntity(String[][] Entity) {
		entity = Entity;
	}
	
	public void setEntity(String Entity,int x, int y) {
		entity[x][y] = Entity;
	}
	
	public void setTabEntity(Entity [][] te) {
		tabEntity = te;
	}
	public void setTabEntity(Entity te,int x,int y) {
		tabEntity[x][y]=te;
	}
	
	/*
	 * methods
	 */
	
	
	public void loadEntity(String FileName) throws Exception{
		//FileReader file = new FileReader(FileName);
		//InputStreamReader file = new InputStreamReader(getClass().getResourceAsStream(FileName));
		System.out.println("../"+FileName);
		System.out.println("test"+getClass().getResourceAsStream("../"+FileName));
		BufferedReader Br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("../"+FileName)));
		String Line;
		
		int i = 0;
		
		while((Line = Br.readLine())!=null) {
			System.out.println("Reading Line "+i+":"+Line);

			String[] split =Line.split("\t");//depending on the data format
			System.out.println("length : "+split.length);
			for (int j = 0;j<split.length;j++) {
				
				
				// setting up entities
				Entity nle = new Entity(i,j,0,Direction.Up,EnumEntity.None);
				
				
				try {
					nle = new Entity(i,j,0,Direction.Up,EnumEntity.valueOf(split[j]));
				}catch(Exception e) {
					System.out.println(e.getMessage());
					
				}finally {
					
					setTabEntity(nle,j,i);
				}
				
				
				
				//setting up monster
				if (getTabEntity(j,i).getType()==EnumEntity.None) { // test if living entity(NPC/monster) or nonLiving Entity(droppedItem)
					
					
					try {
						MonsterType m = MonsterType.valueOf(split[j]);
						
						Monster nlet = new Monster(i,j,0,Direction.Up,m.getLevel(),m.getXp(),m.getXpMax(),m.getLife(),m.getAtk(),m.getDef(),m.name(),m);
						//System.out.println("test"+nlet.getClass());
						//System.out.println("test"+nle.getClass());
						nle = (Entity)nlet.clone();
						System.out.println("autre1 : "+((Monster) nle).getTypeMonster());
						setTabEntity((Monster)nle,j,i);
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
					
				}
				//setting up NPC
				if (getTabEntity(j,i).getType()==EnumEntity.None && !(getTabEntity(j,i) instanceof Monster)) {
					try {
						NpcType m = NpcType.valueOf(split[j]);
						
						nle = new NPC(i,j,0,Direction.Up,m.getLevel(),m.getXp(),m.getXpMax(),m.getLife(),m.getAtk(),m.getDef(),m.name(),m);
						System.out.println("autre1 : "+((NPC) nle).getTypeNPC());
						
						Item item = new Item(9, "NORMAL_HELMET",ItemEnum.NORMAL_HELMET, 1,1);
						DroppedItem di = new DroppedItem(0,0,0,Direction.Up, item, 1);
						
						Item item1 = new Item(9, "NORMAL_SWORD",ItemEnum.NORMAL_SWORD, 1,1);
						DroppedItem di1 = new DroppedItem(0,0,0,Direction.Up, item1, 1);
						
						NPC npc = (NPC)nle;
						npc.pickItem(di);
						npc.pickItem(di1);
						
						setTabEntity(npc,j,i);
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
				}
				setEntity(split[j],j,i);
				System.out.println("Setting up entities ["+i+"]["+j+"] to "+split[j]);
			}
			i++;
		}
		Br.close();//end the reading
	}
	
	
	
	
	public GridPane initEntity() {
		GridPane root = new GridPane();
		for(int i=0;i<getEntity().length;i++) {
			for (int j =0;j<getEntity()[i].length;j++) {
				if(getEntity(i,j)!=null && getEntity(i,j)!="") {
					
					boolean b =false;
					StackPane sp = new StackPane();
					Image image = new Image(getClass().getResourceAsStream("../images/background/map/Grass1x1.png"));//tmp
					//System.out.println(" TMP :images/background/entities/"+getEntity(i, j)+".png");
					//image= new Image("images/background/entities/"+getEntity(i, j)+".png");
					
					if(getTabEntity(i,j) instanceof NPC){
						
						System.out.println("../images/NPC/"+getEntity(i, j)+".png");
						image= new Image(getClass().getResourceAsStream("../images/NPC/"+getEntity(i, j)+".png"));
						b =true;
					}
					
					if(getTabEntity(i,j) instanceof Monster){
						
						System.out.println("../images/monster/"+getEntity(i, j)+".png");
						image= new Image(getClass().getResourceAsStream("../images/monster/"+getEntity(i, j)+".png"));
						((Monster)getTabEntity(i,j)).setStackPane(sp);
						b=true;
					}
					
					if (!b) {
						System.out.println("../images/background/entities/"+getEntity(i, j)+".png");
						image= new Image(getClass().getResourceAsStream("../images/background/entities/"+getEntity(i, j)+".png"));
					}
					
					
					
					/*if(getTabEntity(i,j) instanceof LivingEntity) {
						if(getTabEntity(i,j) instanceof NPC){
							
							System.out.println("images/NPC/"+getEntity(i, j)+".png");
							image= new Image("images/NPC/"+getEntity(i, j)+".png");
						}else  { //only two case
							System.out.println("images/monster/"+getEntity(i, j)+".png");
							image= new Image("images/monster/"+getEntity(i, j)+".png");
						}
					}else {
						
						
						System.out.println("images/background/entities/"+getEntity(i, j)+".png");
						image= new Image("images/background/entities/"+getEntity(i, j)+".png");
						}
					*/
					//System.out.println("images/background/entities/"+getEntity(i, j)+".png");
					//Image image= new Image("images/background/entities/"+getEntity(i, j)+".png");
					ImageView pic = new ImageView();
					
					pic.setFitWidth(50);
					pic.setFitHeight(50);
					pic.setPreserveRatio(true);
					
					pic.setImage(image);
					pic.setOpacity(1);
					sp.getChildren().add(pic);
				
				
				//TEST add player icon
				//ImageView pic2 = new ImageView();
				//pic2.setImage(new Image(joueur.sprite()));
				//sp.getChildren().add(pic2);
				
				
					root.add(sp, i, j);
				}
			}
		}
		return root;
	}
	

}
