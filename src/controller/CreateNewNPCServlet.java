package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//  Auto-generated method stub
		doGet(request, response);
	}

}
