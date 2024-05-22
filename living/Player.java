package living;

import java.util.ArrayList;

import elmt_Base.Direction;

public class Player extends LivingEntity{
	private int deathCount;
	private ArrayList<Quest> ListQuest;
	
	/*
	 * constructor
	 */
	public Player(double x, double y, double weight,Direction Facing,int level,int xp,int xpmax,double life, double atk,double def,String name) {
		super(x, y, weight, Facing,level,xp,xpmax,life,atk,def,name);
		// TODO Auto-generated constructor stub
	}

	public Player(double x, double y, double weight,Direction Facing,double life, double atk,double def,String name) { // constructor light
		super(x,y,weight,Facing,life,atk,def,name);
	}
	
	
	
	/*
	 * getter
	 */
	
	public int getDeathCount() {
		return deathCount;
	}
	public ArrayList<Quest> getListQuest(){
		return ListQuest;
	}
	public Quest getQuest(int index) {
		return ListQuest.get(index);
	}
	
	/*
	 * setter
	 */
	public void setDeathCount(int x) {
		deathCount = x;
	}
	public void setListQuest(ArrayList<Quest> quest) {
		ListQuest = quest;
	}
	public void setQuest(int index, Quest quest) {
		ListQuest.set(index, quest);
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
	
	public void fight(Monster target) {
		int round = 0;
		if (this.getLevel()< target.getLevel()) {
			System.out.println("\nTour n° : "+round+"\n");
			target.hit(this);
			round ++;
		}
		while(this.getLife()>0 || target.getLife()>0) {
			round ++;
			System.out.println("\nTour n° : "+round+"\n");
			this.hit(target);
			if (target.getLife()<=0) {
				System.out.println("\nPlayer won on tour n° : "+round+"\n");
				return ;
			}
			round ++;
			System.out.println("\nTour n° : "+round+"\n");
			target.hit(this);
		}
		System.out.println("\nMonster Won on tour : "+round);
	}
	
	
	public void die() {
		if (getDeathCount()==4) {
			System.out.println("5 morts atteintes, fin de la partie");
			System.exit(1);
			// stop programm
			// to improve
		}
		else {
			setDeathCount(getDeathCount()+1);
		}
		
	}
}
