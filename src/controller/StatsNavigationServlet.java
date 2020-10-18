package controller;

import java.io.IOException;

import javax.persistence.RollbackException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.NPC;
import model.StatBlock;

/**
 * Servlet implementation class StatsNavigationServlet
 */
@WebServlet("/statsNavigationServlet")
public class StatsNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatsNavigationServlet() {
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
		StatBlockHelper dao = new StatBlockHelper();
		
		String act = request.getParameter("doThis");
		
		//After changes redirect to view all if not edit or add
		String path = "/viewAllStatblocksServlet";
		
		if(act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				StatBlock statBlockToDelete = dao.searchById(tempId);
				dao.delete(statBlockToDelete);
			} catch (NumberFormatException e) {
				//  Auto-generated catch block
				System.out.println("No stats selected");
			}catch (RollbackException e) {
				getServletContext().getRequestDispatcher("/viewAllStatblocksServlet").forward(request, response);
			}
		}else if(act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				StatBlock statBlockToEdit = dao.searchById(tempId);
				request.setAttribute("statToEdit", statBlockToEdit);
				path = "/edit-statblock.jsp";
			} catch (NumberFormatException e) {
				//  Auto-generated catch block
				System.out.println("No stats Selected");
			}
		}else if(act.equals("add")) {
			path = "/new-statblock.jsp";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
