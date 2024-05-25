package living;


import java.lang.*;
import java.util.*;
import elmt_Base.Direction;
import living.Sprites.*;
import nonLiving.EnumEntity;


public class NPC extends LivingEntity{//Non Player Character
	private Quest [] quest;
	private NpcType typeNPC;

	/*
	 * constructor
	 */
	public NPC(int x, int y, double weight,Direction Facing,int level,int xp,int xpmax,double life, double atk,double def,String name,NpcType type) {
		super(x, y, weight, Facing,EnumEntity.None,level,xp,xpmax,life,atk,def,name);
		// TODO Auto-generated constructor stub
	}

	

	public NPC(int x, int y, double weight,Direction Facing,double life, double atk,double def,String name,NpcType type) {  // constructor light
		super(x,y,weight,Facing,EnumEntity.None,life,atk,def,name);
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
	public NpcType getTypeNPC() {
		return typeNPC;
	}
	
	
	
	/*
	 * setter
	 */
	public void setQuest(Quest [] quests) {
		quest = quests;
	}
	
	public void setTypeNPC(NpcType type) {
		this.typeNPC=type;
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
	
	
	public String Sprite() {
		return getTypeNPC().getTexture();
	}
	
	
	
}
