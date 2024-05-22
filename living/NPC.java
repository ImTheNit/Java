package living;


import java.lang.*;
import java.util.*;
import elmt_Base.Direction;

public class NPC extends LivingEntity{//Non Player Character
	private Quest [] quest;
	

	/*
	 * constructor
	 */
	public NPC(double x, double y, double weight,Direction Facing,int level,int xp,int xpmax,double life, double atk,double def,String name) {
		super(x, y, weight, Facing,level,xp,xpmax,life,atk,def,name);
		// TODO Auto-generated constructor stub
	}

	

	public NPC(double x, double y, double weight,Direction Facing,double life, double atk,double def,String name) {  // constructor light
		super(x,y,weight,Facing,life,atk,def,name);
	}
	
	
	/*
	 * getter
	 */
	
	public Quest [] getAllQuest() {
		return quest;
	}
	
	public Quest getQuest(int index) {
		if (index<=quest.length) {
			return quest[index];
		}
		return null;
	}
	
	
	
	/*
	 * setter
	 */
	public void setQuest(Quest [] quests) {
		quest = quests;
	}
	
	
	
	
	/*
	 * methods
	 */
	public void addQuests(Quest q) {
		if (getAllQuest().length > 0) {
			//convert tab to list
			List<Quest> list = new ArrayList<Quest>( Arrays.asList(getAllQuest()));
			//add new element to list
			list.add(q);
			//convert list to tab
			Quest [] ret = list.toArray(getAllQuest());
			//update value
			setQuest(ret);
		}else {
			Quest [] ret = new Quest[1];
			ret [0] = q;
			//update value
			setQuest(ret);
		}
	}
	
	public void removeQuest(Quest q) {
		//convert tab to list
		List<Quest> list = new ArrayList<Quest>( Arrays.asList(getAllQuest()));
		
		
		for(int i = 0;i<getAllQuest().length;i++) {
			if(getQuest(i).equals(q)) {
				//remove element from list
				list.remove(q);
			}
		}
		//convert list to tab
		Quest [] ret = list.toArray(getAllQuest());
		//update value
		setQuest(ret);
	}
	
	
	
	
}
