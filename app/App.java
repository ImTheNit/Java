package app;

import elmt_Base.Direction;
import javafx.application.*;
import javafx.stage.*;

import living.*;
import nonLiving.EnumEntity;
import nonLiving.Item.DroppedItem;
import nonLiving.Item.Item;
import nonLiving.Item.ItemEnum;
import app.inventory.*;

import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.image.* ;
import javafx.scene.input.KeyCode;


public class App extends Application{
	
	private ImageView playerView = new ImageView();
	private final int DimX=30;
	private final int DimY=16;
	
	/*
	 * getter
	 */
	
	
	public ImageView getPlayerView() {
		return playerView;
	}
	
	public int getDimX() {
		return DimX;
	}
	
	public int getDimY() {
		return DimY;
	}
	
	/*
	 * setter 
	 */
	
	public void setPlayerView(Player joueur) {
		playerView.setImage(loadImage(joueur));
		playerView.setFitWidth(30);
		playerView.setFitHeight(30);
		playerView.setPreserveRatio(true);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		
		
		MapCreator map = new MapCreator("resources/background.txt",getDimX(),getDimY());
		EntityCreator entities = new EntityCreator("resources/entity.txt",getDimX(),getDimY());
		ItemCreator items = new ItemCreator("resources/items.txt",getDimX(),getDimY());
		FightDisplay fD = new FightDisplay();
		InventoryView InView = new InventoryView();
		//System.out.println("TEST");
		/*
		 * debug use
		 */
		/*
		for(int i=0;i<16;i++) {
			String ret ="Ligne "+i+" : ";
			for (int j = 0;j<30;j++) {
				ret += "["+map.getMap(j, i)+"]";
			}
			System.out.println(ret);
		}
		*/
		Player joueur = new Player(10, 10, 1, Direction.Up, 100, 10, 10, "Joueur1");
		StackPane superRoot = new StackPane();

		GridPane coucheMap = map.initMap();
		
		GridPane coucheEntite = entities.initEntity();
		
		GridPane coucheItem = items.initItem();
		ImageView imv = new ImageView();
		VBox fightDisplay =fD.initDisplay(imv);
		//System.out.println("TEST3");
		VBox coucheInventory = InView.initInventoryView(joueur.getInventory());
		coucheInventory.setOpacity(0);		
		
		
		//System.out.println("TEST4");
		
		setPlayerView(joueur);
		//joueur.getInventory().decreaseSize(5);
		System.out.println("test2 :"+joueur.getInventory().getSize());
		addComponent(coucheMap,map,10,10,loadImage(joueur));
		
		//System.out.println("TEST5");

		superRoot.getChildren().add(coucheMap);
		superRoot.getChildren().add(coucheEntite);
		superRoot.getChildren().add(coucheItem);
		superRoot.getChildren().add(fightDisplay);
		superRoot.getChildren().add(coucheInventory);
		
		Scene scene = new Scene(superRoot,1500,800);
		
		stage.setScene(scene);
		stage.setTitle("Level One");
		stage.show();
		System.out.println("TEST");
		stage.requestFocus();
		
		
		scene.setOnKeyPressed((event) -> { 
			stage.requestFocus();
			switch(event.getCode()) {
			
			case Z:

				//init variables
				int x = joueur.getPosition().getAbscisse();
				int y = joueur.getPosition().getOrdonnee();
				
				mouvementZQSD(Direction.Up, map,  entities, items, coucheMap, coucheEntite, coucheItem, joueur, imv, x, y-1);
				
				break;
				
				
			case Q:

				
				int x1 = joueur.getPosition().getAbscisse();
				int y1 = joueur.getPosition().getOrdonnee();
				
				mouvementZQSD(Direction.Left, map,  entities, items, coucheMap, coucheEntite, coucheItem, joueur, imv, x1-1, y1);
				
				break;
				
				
			case S:

				
				int x2 = joueur.getPosition().getAbscisse();
				int y2 = joueur.getPosition().getOrdonnee();
				
				mouvementZQSD(Direction.Down, map,  entities, items,  coucheMap, coucheEntite, coucheItem, joueur, imv, x2,y2+1);
				
				
				break;
			
			case D:

				int x3 = joueur.getPosition().getAbscisse();
				int y3 = joueur.getPosition().getOrdonnee();
				
				mouvementZQSD(Direction.Right, map,  entities, items, coucheMap, coucheEntite, coucheItem, joueur, imv, x3+1,y3);

				break;
			
			case E:
				//System.out.println(event.getCode());
				imv.setOpacity(0);
				
				
				break;
			
			case A:
				//System.out.println(event.getCode());
				imv.setOpacity(0);
				if (coucheInventory.getOpacity()==0) {
					coucheInventory.setOpacity(1);
				}else {
					coucheInventory.setOpacity(0);
				}
				
				break;
			

			case ESCAPE:
				//System.out.println(event.getCode());
				imv.setOpacity(0);
				
				break;
			
			default:
				imv.setOpacity(0);
				System.out.println(event.getCode());
				break;
				
			}
            
    });
		 
	}
	
	
	
	public Image loadImage(LivingEntity target) {
		Image image= new Image(getClass().getResourceAsStream("../"+target.sprite()));

		
		return image;
	}
	
	public void addComponent(GridPane coucheMap,MapCreator map,int x, int y,Image image2) {
		
		// collect existing component of map
		Image image= new Image(getClass().getResourceAsStream(map.getRefMap()+map.getMap(x, y)+".png"));
		ImageView pic = new ImageView();
		
		
		pic.setFitWidth(50);
		pic.setFitHeight(50);
		pic.setPreserveRatio(true);
		
		pic.setImage(image);
		
		//ImageView pic2 = new ImageView();
		
		
		//pic2.setFitWidth(30);
		//pic2.setFitHeight(30);
		//pic2.setPreserveRatio(true);
		
		//pic2.setImage(image2);
		
		
		StackPane sp = new StackPane();
		sp.getChildren().add(pic);
		sp.getChildren().add(playerView);
		
		coucheMap.add(sp, x, y);
	}
	public void removeComponent(GridPane coucheMap, MapCreator map, int x, int y) {

		((StackPane) playerView.getParent()).getChildren().remove(playerView);
		
	}
	public void removeComponent(GridPane coucheMap, MapCreator map, int x, int y,ImageView old) {
		System.out.println("removing on "+x+y);
		((StackPane) old.getParent()).getChildren().remove(old);
		
	}
	public void updatePosition(MapCreator map, GridPane coucheMap,Player player) { // for player only
		//System.out.println("DEBUT Update ");
		removeComponent(coucheMap,map,player.getOldPosition().getOrdonnee(),player.getOldPosition().getAbscisse());
		
		addComponent(coucheMap,map,player.getPosition().getAbscisse(),player.getPosition().getOrdonnee(),loadImage(player));

		
	}
	/*
	 * remove entity from the map (hide it)
	 * remove entity from []
	 * 
	 */
	public void kill(GridPane coucheEntite,EntityCreator e, int x, int y) {

		((Monster)e.getTabEntity(x,y)).getStackPane().setVisible(false);

		e.setEntity(new String(),x,y);

		e.setTabEntity(new Entity(x,y,0,Direction.Up,EnumEntity.None), x, y);
	}
	/*
	 * remove item from the map (hide it)
	 * remove item from []
	 * 
	 */
	public void pick(GridPane coucheItems,ItemCreator i, int x, int y) {

		i.getTabItem(x,y).getStackPane().setVisible(false);

		i.setItem(new String(),x,y);

		i.setTabItem(new DroppedItem(new Item(),1), x, y);
	}
	
	
	/*
	 * Regroup actions to achieve when a keyboard Z,Q,S,D is touched
	 * 
	 * 
	 * test if case is reachable, crossable and if action is available
	 * 
	 * act if neccessary
	 * 
	 */
	public void mouvementZQSD(Direction Dir,MapCreator map, EntityCreator entities,ItemCreator items, GridPane coucheMap,GridPane coucheEntite,GridPane coucheItem , Player joueur,ImageView imv,int x,int y) {
		imv.setOpacity(0);
		
		joueur.setFacing(Dir);
		setPlayerView(joueur);
		//verifier possible de se déplacer

		
		if (reachable(x,y) & crossable(x,y,entities) & actionable(x,y,entities,items)==0) {
			joueur.move(x-joueur.getPosition().getAbscisse(),y-joueur.getPosition().getOrdonnee() );// depends on cases
			updatePosition(map,coucheMap,joueur);
		}
		switch (actionable(x,y,entities,items)) {
		
		case 1 : //NPC
			
			break;
			
		case 2: //Monster
			if (joueur.fight((Monster)entities.getTabEntity(x,y))<0) {
				imv.setImage(new Image(getClass().getResourceAsStream("../images/fight/defeat.png")));
				imv.setOpacity(0.5);
			}else {
				imv.setImage(new Image(getClass().getResourceAsStream("../images/fight/victory.png")));
				imv.setOpacity(0.5);
				ImageView imv2 = new ImageView();
				//System.out.println("../images/monster/"+((Monster)entities.getTabEntity(x,y)).getTypeMonster().getTexture()+".png");
				imv2.setImage(new Image( getClass().getResourceAsStream("../images/monster/"+((Monster)entities.getTabEntity(x,y)).getTypeMonster().getTexture()+".png" )) );//(Monster)entities.getTabEntity(x,y-1).getSprite()
				//System.out.println("../images/monster/"+((Monster)entities.getTabEntity(x,y)).getTypeMonster().getTexture()+".png");
				//joueur.move(x-joueur.getPosition().getAbscisse(),y-joueur.getPosition().getOrdonnee() );
				updatePosition(map,coucheMap,joueur);
				kill( coucheEntite, entities,  x,  y);
				
			}
			break;
		case 3: //Item
			System.out.println("Collision item");
			joueur.pickItem(items.getTabItem(x, y));
			// en attente de la MAJ de HUD
			pick(coucheItem,items,x,y);
			break;
			
		default:
			break;
		}
	}
	
	
	
	public boolean crossable(int x,int y,EntityCreator e) {
		if(e.getTabEntity(x,y).getType().isCrossable()) {
			//System.out.println(e.getTabEntity(x,y).getType().isCrossable());
			return true;
		}
		else {
			System.out.println("Warning Unable to cross!");
			return false;
		}
		
	}
	public boolean reachable(int x,int y) {
		if (x<0 | x>29 | y<0 | y>15) {
			System.out.println("Warning out of map !");
			return false;
		}else {
			return true;
		}
		
	}
	/*
	 * @return 0 if no action available
	 * @return 1 if action with NPC possible
	 * @return 2 if action with Monster possible
	 * @return 3 if action with item is possible
	 */
	public int actionable(int x, int y,EntityCreator e,ItemCreator i) {
		if(e.getTabEntity(x,y) instanceof NPC ) {
			return 1;
		}
		if(e.getTabEntity(x,y) instanceof Monster) {
			return 2;
		}

		if (i.getTabItem(x,y) instanceof DroppedItem & !i.getTabItem(x,y).getItem().getItemEnum().equals(ItemEnum.EMPTY) & !i.getTabItem(x,y).getItem().getItemEnum().equals(ItemEnum.NONE)) {
			return 3;
		}
		return 0;
	}
	
	
	//public void end()
	
	 
	public static void main(String[] args) {
		launch(args);
	}
	
	
	

}
