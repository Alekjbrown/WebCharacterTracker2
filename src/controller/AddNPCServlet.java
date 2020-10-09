package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.NPC;

/**
 * Servlet implementation class AddItemServlet
 */
@WebServlet("/addNPCServlet")
public class AddNPCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNPCServlet() {
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
		String name = request.getParameter("name");
		String race = request.getParameter("race");
		Integer age = Integer.parseInt(request.getParameter("age"));
		
		NPC npc = new NPC(name,race,age);
		NPCHelper dao = new NPCHelper();
		dao.insert(npc);
		
		//send back to add another
		//TODO change to view detail on this npc
		getServletContext().getRequestDispatcher("/addNPC.jsp").forward(request, response);
	}

}
