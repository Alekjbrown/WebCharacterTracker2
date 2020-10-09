import java.util.List;
import java.util.Scanner;

import controller.NPCHelper;
import model.NPC;

public class start {

	static Scanner in = new Scanner(System.in);
	static NPCHelper NH = new NPCHelper();

	public static void main(String[] args) {
		//  Auto-generated method stub
		runMenu();
	}

	public static void runMenu() {
		boolean goAgain = true;
		while (goAgain) {
			System.out.println("Welcome to a TTRPG NPC Tracker");
			System.out.println("*  Select a menu option");
			System.out.println("*  1. -- Add an NPC");
			System.out.println("*  2. -- Edit an NPC");
			System.out.println("*  3. -- Delete an NPC");
			System.out.println("*  4. -- View the list");
			System.out.println("*  5. -- Exit");
			System.out.print("*  Selection: ");
			int selection = in.nextInt();
			in.nextLine();
			switch (selection) {
			case 1:
				add();
				break;
			case 2:
				edit();
				break;
			case 3:
				delete();
				break;
			case 4:
				viewList();
				break;
			default:
				NH.cleanUp();
				System.out.println("*  BYE!  *");
				goAgain = false;
				break;
			}
		}
	}
	
	private static void viewList() {
		//  Auto-generated method stub
		List<NPC> allNPCS = NH.getAll();
		for(NPC single : allNPCS) {
			System.out.println(single.getId() + ": " + single.Describe());
		}
	}

	private static void delete() {
		//  Auto-generated method stub
		System.out.println("How would you like to search?");
		System.out.println("*  1. -- Search by name");
		System.out.println("*  2. -- Search by race");
		System.out.println("selection:");
		int selection = in.nextInt();
		in.nextLine();
		List<NPC> found;
		if(selection == 1) {
			System.out.print("Enter the NPC name: ");
			String npcName = in.nextLine();
			found = NH.searchByName(npcName);
		}else {
			System.out.print("Enter the NPC race: ");
			String npcRace = in.nextLine();
			found = NH.searchByRace(npcRace);
		}
		
		if(!found.isEmpty()) {
			System.out.println("Found Results");
			for (NPC n : found) {
				System.out.println(n.getId() + ": " + n.Describe());
			}
			System.out.print("ID to Delete: ");
			int idToDelete = in.nextInt();
			NPC toDelete = new NPC();
			for(NPC n : found) {
				if (n.getId() == idToDelete) {
					toDelete = n;
				}
			}
			NH.delete(toDelete);
		}else {
			System.out.println("---No Results Found---");
		}
	}

	private static void edit() {
		//  Auto-generated method stub
		System.out.println("How would you like to search?");
		System.out.println("*  1. -- Search by name");
		System.out.println("*  2. -- Search by race");
		System.out.println("selection: ");
		int selection = in.nextInt();
		in.nextLine();
		List<NPC> found;
		if(selection == 1) {
			System.out.print("Enter the NPC name: ");
			String npcName = in.nextLine();
			found = NH.searchByName(npcName);
		}else {
			System.out.print("Enter the NPC race: ");
			String npcRace = in.nextLine();
			found = NH.searchByRace(npcRace);
		}
		
		if(!found.isEmpty()) {
			System.out.println("Found Results");
			for (NPC n : found) {
				System.out.println(n.getId() + ": " + n.Describe());
			}
			System.out.print("ID to edit: ");
			int idToEdit = in.nextInt();
			
			NPC toEdit = NH.searchByID(idToEdit);
			System.out.println("Retrieved " + toEdit.Describe());
			System.out.println("*  1. -- Update Name");
			System.out.println("*  2. -- Update Race");
			System.out.println("*  3. -- Update Age");
			System.out.println("selection: ");
			selection = in.nextInt();
			in.nextLine();
			
			switch(selection) {
			case 1:
				System.out.print("New name: ");
				String newName = in.nextLine();
				toEdit.setName(newName);
				break;
			case 2: 
				System.out.print("New Race: ");
				String newRace = in.nextLine();
				toEdit.setRace(newRace);
				break;
			case 3:
				System.out.print("New age: ");
				int newAge = in.nextInt();
				in.nextLine();
				toEdit.setAge(newAge);
				break;
			default:break;
			}
			
			NH.update(toEdit);
		}else {
			System.out.println("---No Results Found---");
		}
	}

	private static void add() {
		System.out.print("Enter a name: ");
		String name = in.nextLine();
		System.out.print("Enter race: ");
		String race = in.nextLine();
		System.out.print("Enter age: ");
		int age = in.nextInt();
		in.nextLine();
		NPC toAdd = new NPC(name,race,age);
		NH.insert(toAdd);
	}	

}