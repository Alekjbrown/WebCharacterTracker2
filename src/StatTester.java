import java.time.LocalDate;
import java.util.List;

import controller.NPCDetailsHelper;
import controller.StatBlockHelper;
import model.NPC;
import model.NPCDetails;
import model.StatBlock;

public class StatTester {

	public static void main(String[] args) {
		//  Auto-generated method stub
		StatBlock barbarian = new StatBlock(15,12,14,8,10,13);
		
		NPC bob = new NPC("bob","Half-Orc",25);
		
		StatBlockHelper sbh = new StatBlockHelper();
		
		NPCDetailsHelper ndh = new NPCDetailsHelper();
		NPCDetails barbBlock = new NPCDetails(LocalDate.now(),bob,barbarian);
		
		ndh.insertNewNPCDetails(barbBlock);
		
		List<NPCDetails> allNPCDetails = ndh.getNPCS();
		
		for(NPCDetails a: allNPCDetails) {
			System.out.println(a.toString());
		}
		
//		List<StatBlock> allStatBlocks = sbh.showAllStatBlocks();
//		for(StatBlock a: allStatBlocks) {
//			System.out.println(a.toString());
//		}
	}

}
