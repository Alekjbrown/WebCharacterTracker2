package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.NPC;

/**
 * Servlet implementation class EditNPCServlet
 */
@WebServlet("/editNPCServlet")
public class EditNPCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditNPCServlet() {
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
//		doGet(request, response);
		NPCHelper dao = new NPCHelper();
		
		String name = request.getParameter("name");
		String race = request.getParameter("race");
		Integer age = Integer.parseInt(request.getParameter("age"));
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		NPC npcToUpdate = dao.searchByID(tempId);
		npcToUpdate.setName(name);
		npcToUpdate.setRace(race);
		npcToUpdate.setAge(age);
		
		dao.update(npcToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllNPCServlet").forward(request, response);
	}

}
