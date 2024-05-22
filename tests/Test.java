package tests;

import elmt_Base.*;
import living.*;
import nonLiving.*;
import nonLiving.Item.*;

import java.io.*;

public class Test {

	public void fileExtractor(String file) throws IOException{
	    InputStream is = new FileInputStream("file.txt");
	    InputStreamReader isr = new InputStreamReader(is);
	    BufferedReader buffer = new BufferedReader(isr);
	        
	    String line = buffer.readLine();
	    StringBuilder builder = new StringBuilder();
	        
	    while(line != null){
	       builder.append(line).append("\n");
	       line = buffer.readLine();
	    }
	        
	    String str = builder.toString();
	    System.out.println(str);
	}
	
	public static void main(String [] args) throws CloneNotSupportedException {
		System.out.println("//JOUEUR//\n");
		Player joueur = new Player(0, 0, 1, Direction.Down, 100, 10, 10, "Joueur1");
		System.out.println(joueur.toString());
		
		
		joueur.decreaseAtk(0.2);
		joueur.gainXp(75);
		joueur.move(10, 10);
		joueur.gainLevel();
		joueur.gainXp(25);
		//joueur.setInventory();
		
		System.out.println("//Joueur après modif//\n");
		System.out.println(joueur.toString());
		
		
		
		System.out.println("\n\n//Item//\n");
		Item MonItem = new Item(1,"sword#1",ItemEnum.NORMAL_SWORD,75,100);
		Item popo = new Item(20,"popo#1",ItemEnum.SMALL_LIFE_POTION,1,1);
		Item popo2 = new Item(21,"popo#2", ItemEnum.MEDIUM_LIFE_POTION,1,1);

		
		DroppedItem dMonItem = new DroppedItem(MonItem,1);
		DroppedItem dpopo = new DroppedItem(popo,30);
		DroppedItem dpopo2 = new DroppedItem(popo2,10);
		MonItem.repair(12);
		MonItem.useDurability();
		
	
		
		
		
		System.out.println("\n\nAffichage Inventaire joueur");
		System.out.println(joueur.getInventory().toString());
		
		
		/*
		System.out.println("\n\nAffichage Inventaire ");
		Inventory invent = new Inventory();
		System.out.println(invent.toString());
		invent.add(MonItem, 2, 1);
		System.out.println(invent.toString());
		*/
		
		
		
		System.out.println("\n\nAffichage pickItem\n\n");
		System.out.println(joueur.getInventory().toString());
		joueur.pickItem(dpopo);
		System.out.println(joueur.getInventory().toString());
		//joueur.getInventory().add(popo,1,1);
		//joueur.pickItem(dpopo);//ko
		joueur.pickItem(dpopo2);
		//joueur.pickItem(dpopo2);
		System.out.println(joueur.getInventory().toString());
		//joueur.pickItem(dpopo2);
		
		
		
		System.out.println("\n\n//AFFICHAGE QUETES//\n");
		
		Quest quete1 = new Quest(joueur.getInventory().getContent(),12,12);
		System.out.println(quete1.toString());
		
		Item Helmet = new Item(12,"helmet1",ItemEnum.NORMAL_HELMET,1,1);
		SlotInventory slotHelmet= new SlotInventory(Helmet,1,true);
		Item Helmet2 = new Item(13,"helmet2",ItemEnum.LIFE_HELMET,1,1);
		SlotInventory slotHelmet2= new SlotInventory(Helmet2,1,true);
		Item Helmet3 = new Item(14,"helmet2",ItemEnum.ATK_HELMET,1,1);
		SlotInventory slotHelmet3= new SlotInventory(Helmet3,1,true);
		
		
		System.out.println("\nTEST PASSIV\n");
		System.out.println(joueur.toString());
		joueur.wear(slotHelmet);
		System.out.println("\n"+joueur.toString());
		joueur.wear(slotHelmet2);
		System.out.println("\n"+joueur.toString());
		joueur.wear(slotHelmet3);
		
		
		
		/*
		joueur.wear(slotHelmet);
		joueur.wear(slotHelmet2);
		System.out.println(joueur.getInventory().toString());
		//joueur.setInventory();
		System.out.println(joueur.getInventory().toString());
		
		
		
		
		System.out.println("size : "+joueur.getInventory().getSize());
		joueur.getInventory().decreaseSize(1);
		System.out.println("size : "+joueur.getInventory().getSize());
		System.out.println("\n\nTEST\n\n"+joueur.getInventory().toString());
		
		System.out.println("\n\n\nretiré:"+joueur.dropItem(0, 5));
		System.out.println("\n\ntest REMOVE");
		System.out.println(joueur.getInventory().toString());
		
		
		
		
		
		/*
		System.out.println("SlotInvent vide"+new SlotInventory().isEmpty());
		Inventory INVENTAIRE = new Inventory();
		INVENTAIRE.add(MonItem, 0, 1);
		INVENTAIRE.add(MonItem, 1, 1);
		INVENTAIRE.add(MonItem, 2, 1);
		INVENTAIRE.add(MonItem, 3, 1);
		INVENTAIRE.add(MonItem, 4, 1);
		System.out.println("TEST"+INVENTAIRE.getNextEmpty());
		
		*/
		
		
		
		
		
		System.out.println("//Monster//\n");
		Monster monster = new Monster(0, 0, 1, Direction.Down, 100, 10, 10, "Monster1");
		System.out.println(monster.toString());
		
		
		System.out.println("//FIGHT//\n");
		joueur.fight(monster);
		
		System.out.println("//FIN DU FIGHT//\n\n");
		NPC PNJ = new NPC(0, 0, 1, Direction.Down, 100, 10, 10, "PNJ1");
		System.out.println("//PNJ//\n");
		System.out.println(PNJ.toString());
		
		
		
	}
}
