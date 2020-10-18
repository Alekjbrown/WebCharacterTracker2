package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.NPC;
import model.NPCDetails;
import model.StatBlock;

/**
 * Servlet implementation class EditNPCDetailServlet
 */
@WebServlet("/editNPCDetailServlet")
public class EditNPCDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditNPCDetailServlet() {
        super();
        //  Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		//  Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//  Auto-generated method stub
		NPCHelper nh = new NPCHelper();
		StatBlockHelper sbh = new StatBlockHelper();
		NPCDetailsHelper ndh = new NPCDetailsHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		NPCDetails NPCToUpdate = ndh.searchForNPCDetailsById(tempId);
		NPC n = nh.searchByID(NPCToUpdate.getNpc().getId());
		
		String newName = request.getParameter("name");
		String newRace = request.getParameter("race");
		Integer newAge = Integer.parseInt(request.getParameter("age"));
		
		String selectedStat = request.getParameter("statblockToAdd");
		StatBlock s = new StatBlock();
		if(!selectedStat.isEmpty()) {
			System.out.println(selectedStat);
			s = sbh.searchById(Integer.parseInt(selectedStat));
		}
		
		n.setName(newName);
		n.setRace(newRace);
		n.setAge(newAge);
		
		NPCToUpdate.setNpc(n);
		NPCToUpdate.setStatblock(s);
		ndh.updateList(NPCToUpdate);
		
		System.out.println("Success");
		System.out.println(NPCToUpdate.toString());
		
		getServletContext().getRequestDispatcher("/viewAllNPCDetailsServlet").forward(request, response);
		
	}

}
