package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.NPC;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NavigationServlet() {
		super();
		// Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		//  Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Auto-generated method stub
//		doGet(request, response);
		NPCHelper dao = new NPCHelper();
		
		String act = request.getParameter("doThis");
		
		//After changes redirect to view all if not edit or add
		String path = "/viewAllNPCServlet";
		
		if(act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				NPC npcToDelete = dao.searchByID(tempId);
				dao.delete(npcToDelete);
			} catch (NumberFormatException e) {
				//  Auto-generated catch block
				System.out.println("No NPC selected");
			}
		}else if(act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				NPC npcToEdit = dao.searchByID(tempId);
				request.setAttribute("npcToEdit", npcToEdit);
				path = "/edit-NPC.jsp";
			} catch (NumberFormatException e) {
				//  Auto-generated catch block
				System.out.println("No NPC Selected");
			}
		}else if(act.equals("add")) {
			path = "/addNPC.jsp";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
