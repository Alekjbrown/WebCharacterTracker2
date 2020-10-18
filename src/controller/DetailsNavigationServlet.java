package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.NPCDetails;

/**
 * Servlet implementation class DetailsNavigationServlet
 */
@WebServlet("/detailsNavigationServlet")
public class DetailsNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailsNavigationServlet() {
        super();
        //  Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//  Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//  Auto-generated method stub
		NPCDetailsHelper dao = new NPCDetailsHelper();
		String act = request.getParameter("doThis");
		
		if(act==null) {
			//no button selected
			getServletContext().getRequestDispatcher("/viewAllNPCDetailsServlet").forward(request, response);
		}else if(act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				NPCDetails listToDelete = dao.searchForNPCDetailsById(tempId);
				dao.deleteList(listToDelete);
				}catch(NumberFormatException e) {
					System.out.println("Forgot to click a button");
				}finally {
					getServletContext().getRequestDispatcher("/viewAllNPCDetailsServlet").forward(request, response);
				}
		}else if(act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				NPCDetails npcToEdit = dao.searchForNPCDetailsById(tempId);
				request.setAttribute("NPCToEdit", npcToEdit);
				
				request.setAttribute("month", npcToEdit.getCreatedDate().getMonthValue());
				request.setAttribute("date", npcToEdit.getCreatedDate().getDayOfMonth());
				request.setAttribute("year", npcToEdit.getCreatedDate().getYear());
				
				StatBlockHelper sbh = new StatBlockHelper();
				
				request.setAttribute("allStatblocks", sbh.getAll());
				
				if(sbh.getAll().isEmpty()) {
					request.setAttribute("allStatblocks", " ");
				}
				
				getServletContext().getRequestDispatcher("/edit-NPCDetail.jsp").forward(request, response);
			}catch(NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllNPCDetailsServlet").forward(request, response);
			}
		}else if(act.equals("add")) {
			getServletContext().getRequestDispatcher("/new-npc-details.jsp").forward(request, response);
		}
	}

}
