package living;

import java.util.ArrayList;

import elmt_Base.Direction;
import elmt_Base.Point2D;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import nonLiving.EnumEntity;

public class Player extends LivingEntity{
	private int deathCount;
	private int killCount;
	private ArrayList<Quest> ListQuest;
	private static final String texture = "player";
	public Point2D oldPosition;
	
	/*
	 * constructor
	 */
	public Player(int x, int y, double weight,Direction Facing,int level,int xp,int xpmax,double life, double atk,double def,String name) {
		super(x, y, weight, Facing,EnumEntity.None,level,xp,xpmax,life,atk,def,name);
		setOldPosition(new Point2D(0,0));
		// TODO Auto-generated constructor stub
	}

	public Player(int x, int y, double weight,Direction Facing,double life, double atk,double def,String name) { // constructor light
		super(x,y,weight,Facing,EnumEntity.None,life,atk,def,name);
		setOldPosition(new Point2D(0,0));
	}
	
	
	
	/*
	 * getter
	 */
	
	public int getDeathCount() {
		return deathCount;
	}
	public int getKillCount() {
		return killCount;
	}
	public ArrayList<Quest> getListQuest(){
		return ListQuest;
	}
	public Quest getQuest(int index) {
		return ListQuest.get(index);
	}
	public String getTexture() {
		return texture;
	}
	public Point2D getOldPosition() {
		return oldPosition;
	}
	
	/*
	 * setter
	 */
	public void setDeathCount(int x) {
		deathCount = x;
	}
	public void setKillCount(int x) {
		killCount = x;
	}
	public void setListQuest(ArrayList<Quest> quest) {
		ListQuest = quest;
	}
	public void setQuest(int index, Quest quest) {
		ListQuest.set(index, quest);
	}
	public void setOldPosition(Point2D p) {
		Point2D p2 = new Point2D(p.getAbscisse(),p.getOrdonnee());
		oldPosition =p2;
	}
	
	
	/*
	 * methods
	 */
	public void initQuests() {
		setListQuest(new ArrayList<Quest>(3));
	}
	public boolean isFullQuest() {
		for (int i =0; i<3;i++) {
			if (getQuest(1)==null) {
				return false;
			}
		}
		return true;
	}
	
	public void addQuest(Quest quest) {
		if (!isFullQuest()) {
			for(int i =0; i<3;i++) {
				if(getQuest(i)==null) {
					setQuest(i,quest);
				}
			}
		}else {
			System.out.println("Already full of quests");
		}
	}
	
	
	/*
	 * @return the round where the fight 
	 * @return -/+ in case of defeat/victory
	 * 
	 * example of return : -2 defeat on round 2
	 * 					    4 victory on round 4
	 */
	public double fight(Monster target) {
		int round = 0;
		if (this.getLevel()< target.getLevel()) {
			System.out.println("\nTour n° : "+round+"\n");
			target.hit(this);
			round ++;
		}
		
		while(this.getLife()>0 && target.getLife()>0) {
			round ++;
			System.out.println("\nTour n° : "+round+"\n");
			this.hit(target);
			if (target.getLife()<=0) {
				System.out.println("\nPlayer won on tour n° : "+round+"\n");
				setLife(getBaseMaxLife());
				kill();
				return round;
			}
			round ++;
			System.out.println("\nTour n° : "+round+"\n");
			target.hit(this);
		}
		System.out.println("\nMonster Won on tour : "+round);
		//reset life
		setLife(getBaseMaxLife());
		target.setLife(target.getBaseMaxLife());
		die();//increment deathcount
		return -round;
	}
	public void kill() {
		setKillCount(getKillCount()+1);
	}
	
	
	public void die() {
		if (getDeathCount()>=4) {
			System.out.println("5 morts atteintes, fin de la partie");
			//System.exit(1);
			Text text = new Text("5 morts atteintes, fin de la partie");
			Button b1 = new Button("OK");
			
			
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
			
			NewStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
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
			NewStage.setTitle("Fin de Partie");
			NewStage.setResizable(false);
			NewStage.show();

		}
		else {
			setDeathCount(getDeathCount()+1);
		}
		
	}
	public void move(int x,int y) {
		//verify possible TODO
		setOldPosition(getPosition());
		super.move(x, y);
	}
	
	public String sprite() {
		return "images/player/"+getTexture()+"_"+getFacing().name().toLowerCase()+".png";
	}
	
	
	
	
	
	
	
}
