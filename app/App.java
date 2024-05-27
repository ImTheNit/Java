package app;

import elmt_Base.Direction;
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.*;

import living.*;
import nonLiving.EnumEntity;
import nonLiving.SlotInventory;
import nonLiving.Item.ActivEffect;
import nonLiving.Item.DroppedItem;
import nonLiving.Item.Item;
import nonLiving.Item.ItemEnum;
import nonLiving.Item.ItemGroup;

import java.util.concurrent.ThreadLocalRandom;

import app.inventory.*;

import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.image.* ;
import javafx.scene.input.KeyCode;
import javafx.scene.text.*;


public class App extends Application{
	
	private ImageView playerView = new ImageView();
	private final int DimX=30;
	private final int DimY=16;
	private final int killGoal = 15;
	private VBox CoucheInventory;
	
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
	public int getKillGoal() {
		return killGoal;
	}
	public VBox getCoucheInventory() {
		return CoucheInventory;
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
	public void setCoucheInventory(VBox CoucheInventory) {
		this.CoucheInventory = CoucheInventory;
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		
		
		MapCreator map = new MapCreator("resources/background.txt",getDimX(),getDimY());
		EntityCreator entities = new EntityCreator("resources/entity.txt",getDimX(),getDimY());
		ItemCreator items = new ItemCreator("resources/items.txt",getDimX(),getDimY());
		FightDisplay fD = new FightDisplay();
		InventoryView InView = new InventoryView();
		setCoucheInventory(new VBox());
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
		

		joueur.getInventory().setSize(5);

		
		Item item = new Item(9, "SMALL_RED_POTION",ItemEnum.SMALL_RED_POTION, 1,1);
		DroppedItem di = new DroppedItem(0,0,0,Direction.Up, item, 1);
		
		Item item1 = new Item(9, "MEDIUM_RED_POTION",ItemEnum.MEDIUM_RED_POTION, 1,1);
		DroppedItem di1 = new DroppedItem(0,0,0,Direction.Up, item1, 1);
		
		Item item2 = new Item(9, "BIG_RED_POTION",ItemEnum.BIG_RED_POTION, 1,1);
		DroppedItem di2 = new DroppedItem(0,0,0,Direction.Up, item2, 1);
		
		Item item3 = new Item(9, "SMALL_BLUE_POTION",ItemEnum.SMALL_BLUE_POTION, 1,1);
		DroppedItem di3 = new DroppedItem(0,0,0,Direction.Up, item3, 1);
		
		Item item4 = new Item(9, "MEDIUM_BLUE_POTION",ItemEnum.MEDIUM_BLUE_POTION, 1,1);
		DroppedItem di4 = new DroppedItem(0,0,0,Direction.Up, item4, 1);
		
		joueur.pickItem(di);
		joueur.pickItem(di1);
		joueur.pickItem(di2);
		joueur.pickItem(di3);
		joueur.pickItem(di4);
		
		
		//joueur.pickItem(di);
		StackPane superRoot = new StackPane();

		GridPane coucheMap = map.initMap();
		
		GridPane coucheEntite = entities.initEntity();
		
		GridPane coucheItem = items.initItem();
		ImageView imv = new ImageView();
		VBox fightDisplay =fD.initDisplay(imv);
		//System.out.println("TEST3");
		InView.initInventoryView(joueur.getInventory());
		//VBox coucheInventory = InView.getInventoryVbox();
		setCoucheInventory(InView.getInventoryVbox());
		getCoucheInventory().setOpacity(0);		
		
		
		//System.out.println("TEST4");
		
		setPlayerView(joueur);
		//joueur.getInventory().decreaseSize(5);
		
		addComponent(coucheMap,map,10,10,loadImage(joueur));
		
		//System.out.println("TEST5");

		superRoot.getChildren().add(coucheMap);
		superRoot.getChildren().add(coucheEntite);
		superRoot.getChildren().add(coucheItem);
		superRoot.getChildren().add(fightDisplay);
		superRoot.getChildren().add(getCoucheInventory());
		
		Scene scene = new Scene(superRoot,1500,800);
		
		stage.setScene(scene);
		stage.getIcons().add(new Image(getClass().getResourceAsStream("../images/player/player_down.png")));
		stage.setTitle("Level One");
		stage.show();
		
		stage.requestFocus();
		stage.setResizable(false);
		
		
		scene.setOnKeyPressed((event) -> { 
			stage.requestFocus();
			
			
			switch(event.getCode()) {
			
			case Z:

				//init variables
				int x = joueur.getPosition().getAbscisse();
				int y = joueur.getPosition().getOrdonnee();
				
				mouvementZQSD(stage,superRoot,Direction.Up, map,  entities, items, InView, coucheMap, coucheEntite, coucheItem, joueur, imv, x, y-1);
				
				break;
				
				
			case Q:

				
				int x1 = joueur.getPosition().getAbscisse();
				int y1 = joueur.getPosition().getOrdonnee();
				
				mouvementZQSD(stage,superRoot,Direction.Left, map,  entities, items, InView, coucheMap, coucheEntite, coucheItem, joueur, imv, x1-1, y1);
				
				break;
				
				
			case S:

				
				int x2 = joueur.getPosition().getAbscisse();
				int y2 = joueur.getPosition().getOrdonnee();
				
				mouvementZQSD(stage,superRoot,Direction.Down, map,  entities, items, InView,  coucheMap, coucheEntite, coucheItem, joueur, imv, x2,y2+1);
				
				
				break;
			
			case D:

				int x3 = joueur.getPosition().getAbscisse();
				int y3 = joueur.getPosition().getOrdonnee();
				
				mouvementZQSD(stage,superRoot,Direction.Right, map,  entities, items, InView, coucheMap, coucheEntite, coucheItem, joueur, imv, x3+1,y3);

				break;
			
			case E:
				//System.out.println(event.getCode());
				imv.setOpacity(0);
				System.out.println("test entité 1"+entities.getTabEntity(1, 1));
				System.out.println("test entité 2"+entities.getTabEntity(2, 1));
				System.out.println("test entité 3"+entities.getTabEntity(3, 1));
				//System.out.println(entities.getTabEntity(1, 4));
				
				
				
				break;
			
			case A:
				System.out.println(event.getCode() );
				System.out.println(InView.getInventoryVbox().getOpacity());
				imv.setOpacity(0);
				if (InView.getInventoryVbox().getOpacity()==0) {
					InView.getInventoryVbox().setOpacity(1);
				}else {
					InView.getInventoryVbox().setOpacity(0);
				}
				
				break;
			
				
			

			case ESCAPE:
				//System.out.println(event.getCode());
				imv.setOpacity(0);
				quit();
				
				break;
				
				
			case  H : //history
				System.out.println("history");
				for (int i=0;i<joueur.getInventory().getSize();i++) {
					if(joueur.getInventory().getContent(i).getItem().getItemEnum().getAeffect()==ActivEffect.DisplayNPCInventory) {
						System.out.println("Item possédé\n\n");
						for(int j =0;j<joueur.getListNPC().size();j++) {
							System.out.println("NPC "+(j+1)+"\n"+joueur.getListNPC(j).getInventory() +"\n\n");
						}
						try {
							DroppedItem dpi = joueur.dropItem(i,1);
						} catch (CloneNotSupportedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						updateInventoryView( superRoot, InView, joueur);
					}
				}
				break;
				
				
			case T://teleport
				System.out.println("teleport");
				for (int i=0;i<joueur.getInventory().getSize();i++) {
					if(joueur.getInventory().getContent(i).getItem().getItemEnum().getAeffect()==ActivEffect.Teleport) {
						System.out.println("Item possédé");
						int randomNum1 = ThreadLocalRandom.current().nextInt( 0, getDimX());
						int randomNum2 = ThreadLocalRandom.current().nextInt( 0, getDimY());
						mouvementZQSD(stage,superRoot,Direction.Up, map,  entities, items, InView, coucheMap, coucheEntite, coucheItem, joueur, imv, randomNum1, randomNum2);
						
					}
				}

				break;
				
				
			case F://Finish
				System.out.println("Finish");
				for (int i=0;i<joueur.getInventory().getSize();i++) {
					if(joueur.getInventory().getContent(i).getItem().getItemEnum().getAeffect()==ActivEffect.HappyEnd) {
						System.out.println("Item possédé");
						win();
						
					}
				}
				break;
			
				
			case V://Vampirism
				System.out.println("Vampirism");
				for (int i=0;i<joueur.getInventory().getSize();i++) {
					if(joueur.getInventory().getContent(i).getItem().getItemEnum().getAeffect()==ActivEffect.AbsorbLife) {
						System.out.println("Item possédé");
						vampirise(joueur,coucheEntite,entities,items);
					}
				}
				
				
				break;
				
			case O:
				
				//System.out.println(joueur.getInventory());
				System.out.println(joueur.toString());
				//InView.updateInventoryView(joueur.getInventory());
				
				break;
			case U:
				/*Item item2 = new Item(10, "NORMAL_HELMET",ItemEnum.NORMAL_HELMET, 1,1);
				DroppedItem di2 = new DroppedItem(0,0,0,Direction.Up, item2, 1);
				
				pickItem(superRoot,InView,joueur,di2);*/
				break;
			case K:
				System.out.println(joueur.getInventory());
				break;

			default:
				imv.setOpacity(0);
				System.out.println(event.getCode());
				break;
				
			}
			if (joueur.getDeathCount()>=4 || joueur.getKillCount()>=getKillGoal()) {
				return;
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
	public void mouvementZQSD(Stage stage,StackPane superRoot,Direction Dir,MapCreator map, EntityCreator entities,ItemCreator items, InventoryView InView, GridPane coucheMap,GridPane coucheEntite,GridPane coucheItem , Player joueur,ImageView imv,int x,int y) {
		
		
		
		
		
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
			/*Tooltip ttip =new Tooltip();
			ttip.setText("je suis un PNJ");
			ttip.setFont(Font.font("Arial", FontPosture.ITALIC, 15));
			
			Label l = new Label("I'm a NPC ");
			l.setStyle("-fx-padding:50px;");
			l.setAlignment(Pos.CENTER);
			l.setTooltip(ttip);
			TilePane r = new TilePane();
			r.setAlignment(Pos.CENTER_LEFT);
			
			
			
			
			r.getChildren().add(l);
			superRoot.getChildren().add(r);*/
			NPC target = ((NPC)entities.getTabEntity(x,y));
			joueur.addNPC(target);
			System.out.println("Hello i'm a NPC and here is my inventory :\n"+target.getInventory());
			
			break;
			
		case 2: //Monster
			if (joueur.fight((Monster)entities.getTabEntity(x,y))<=0) {
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
				System.out.println("killCount"+joueur.getKillCount());
				if (joueur.getKillCount()>=getKillGoal()) {
					System.out.println("killCount"+joueur.getKillCount());
					win();
				}
			}
			break;
		case 3: //Item
			System.out.println("Collision item");
			if (items.getTabItem(x, y).getItem().getItemEnum().getType().getGroup()==ItemGroup.EQUIPMENT) {
				//pickItem(superRoot,InView,joueur,items.getTabItem(x, y));
				joueur.wear(new SlotInventory(items.getTabItem(x, y).getItem(),items.getTabItem(x, y).getQuantity(),true));
				updateInventoryView(superRoot,InView,joueur);
				
			}else {
				//if (joueur.getInventory().) // TODO test full
				if (!joueur.getInventory().isFull()) {
					pickItem(superRoot,InView,joueur,items.getTabItem(x, y));
					pick(coucheItem,items,x,y);
				}
				
			}
			
			//joueur.pickItem(items.getTabItem(x, y));
			// en attente de la MAJ de HUD
			//pick(coucheItem,items,x,y);
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
	
	
	public void quit() {
		Text text = new Text("Voulez vous quitter ?");
		Button b1 = new Button("Oui");
		Button b2 = new Button("Non");
		
		VBox vbox = new VBox();
		Stage NewStage = new Stage();
		Scene scene = new Scene(vbox,250,80);
		GridPane gp1 = new GridPane();
		GridPane gp2 = new GridPane();
		
		text.setStyle("-fx-font-weight: bold");
		
		
		b1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				Platform.exit();
				System.exit(0);
			}
			
		
		});
		b2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				NewStage.close();
			}
			
		
		});
		NewStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
		    @Override
		    public void handle(WindowEvent event) {
		        event.consume();
		    }
		});
		
		
		gp1.add(text, 0, 0);
		gp1.setAlignment(Pos.CENTER);
		
		gp2.add(b1, 0, 0);
		gp2.add(b2, 1%2, 1/2);
		gp2.setAlignment(Pos.CENTER);
		gp2.setHgap(20);
		
		
		vbox.getChildren().addAll(gp1,gp2);
		vbox.setSpacing(20);
		NewStage.setScene(scene);
		NewStage.getIcons().add(new Image(getClass().getResourceAsStream("../images/player/player_down.png")));
		NewStage.setTitle("Confirmation");
		NewStage.setResizable(false);
		NewStage.show();
		//NewStage.requestFocus();
		
	}
	public void win() {
		Text text = new Text("Félicitation vous avez gagné, \nrelancez le jeu pour une nouvelle partie ");
		Button b1 = new Button("OK");
		
		
		VBox vbox = new VBox();
		Stage NewStage = new Stage();
		Scene scene = new Scene(vbox,250,80);
		GridPane gp1 = new GridPane();
		GridPane gp2 = new GridPane();
		
		text.setStyle("-fx-font-weight: bold");
		text.setTextAlignment(TextAlignment.CENTER);
		
		b1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				Platform.exit();
				System.exit(0);
			}
		});
		NewStage.setOnCloseRequest(new EventHandler<WindowEvent>() { // cancel closing
		    @Override
		    public void handle(WindowEvent event) {
		        event.consume();
		    }
		});
		
		
		gp1.add(text, 0, 0);
		gp1.setAlignment(Pos.CENTER);
		
		gp2.add(b1, 0, 0);
		gp2.setAlignment(Pos.CENTER);
		gp2.setHgap(20);
		
		
		vbox.getChildren().addAll(gp1,gp2);
		vbox.setSpacing(20);
		NewStage.setScene(scene);
		NewStage.getIcons().add(new Image(getClass().getResourceAsStream("../images/player/player_down.png")));
		NewStage.setTitle("Bravo");
		NewStage.setResizable(false);
		NewStage.show();
	}
	
	
	public void pickItem(StackPane superRoot,InventoryView InView,Player joueur,DroppedItem droppedItem) {
		joueur.pickItem(droppedItem);
		updateInventoryView(superRoot,InView,joueur);
	}
	
	
	public void updateInventoryView(StackPane superRoot,InventoryView InView,Player joueur) {
		superRoot.getChildren().remove(getCoucheInventory());
		InView.updateInventoryView(joueur.getInventory());
		setCoucheInventory(InView.getInventoryVbox());
		superRoot.getChildren().add(getCoucheInventory());
	}
	public static void main(String[] args) {
		launch(args);
	}
	
	public void vampirise(Player joueur,GridPane coucheEntite,EntityCreator e,ItemCreator i) {
		int X=0;
		int Y=0;
		int X1 = joueur.getPosition().getAbscisse();
		int Y1 = joueur.getPosition().getOrdonnee();
		
		switch(joueur.getFacing()) {
		
			case Up:
				//x, y-1
				X = X1 ;
				Y = Y1-1;
				break;
				
			case Down:
				//x2,y2+1
				X = X1 ;
				Y = Y1+1;
				break;
				
			case Left:
				//x1-1, y1
				X = X1 -1 ;
				Y = Y1;
				break;
				
			case Right:
				X = X1+1 ;
				Y = Y1;
				break;
				
			default:
				System.out.println("Wrong facing of the player");
				break;
		}
		 if (actionable(X, Y, e,i) == 2) { // facing a monster
			 joueur.increaseLife(((Monster)e.getTabEntity(X,Y)).getLife());
			 kill(coucheEntite,e,X,Y);
		 }
		
		
	}
	

}
