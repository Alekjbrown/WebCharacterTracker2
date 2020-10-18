package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.NPC;
import model.NPCDetails;
import model.StatBlock;

/**
 * Servlet implementation class CreateNewNPCServlet
 */
@WebServlet("/createNewNPCServlet")
public class CreateNewNPCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewNPCServlet() {
        super();
        //  Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//  Auto-generated method stub
		NPCDetailsHelper ndh = new NPCDetailsHelper();
		String name = request.getParameter("npcName");
		String race = request.getParameter("npcRace");
		int age;
		try {
			age = Integer.parseInt(request.getParameter("npcAge"));
		}catch (NumberFormatException ex) {
			age = 0;
		}
		System.out.println("NPC Name: " + name + "\nNPC Race: " + race +
				"\nNPC Age: " + age);
		
		StatBlockHelper sbh = new StatBlockHelper();
		String selectedStatBlock = request.getParameter("statblockToAdd");
		StatBlock s = new StatBlock();
		if(!selectedStatBlock.isEmpty()) {
			System.out.println(selectedStatBlock);
			s = sbh.searchById(Integer.parseInt(selectedStatBlock));
		}
		
		NPC n = new NPC(name,race,age);
		
		LocalDate ld = LocalDate.now();
		
		NPCDetails nd = new NPCDetails(ld,n,s);
		ndh.insertNewNPCDetails(nd);
		
		System.out.println("Success");
		System.out.println(nd.toString());
		
		getServletContext().getRequestDispatcher("/viewAllNPCDetailsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//  Auto-generated method stub
		doGet(request, response);
	}

}
