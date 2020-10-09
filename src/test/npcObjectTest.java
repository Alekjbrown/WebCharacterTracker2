package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.NPC;

public class npcObjectTest {

	NPC npc = new NPC("Tasha","demigod",950);
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		assertEquals(npc.Describe(),"Tasha is a 950 Y/O demigod");
	}

}
