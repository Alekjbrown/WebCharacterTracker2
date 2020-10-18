package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.NPCDetails;

/**
 * Servlet implementation class ViewAllNPCDetailsServlet
 */
@WebServlet("/viewAllNPCDetailsServlet")
public class ViewAllNPCDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllNPCDetailsServlet() {
        super();
        //  Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//  Auto-generated method stub
		NPCDetailsHelper ndh = new NPCDetailsHelper();
		List<NPCDetails> detailsList = ndh.getNPCS();
		request.setAttribute("allNpcs", detailsList);
		String path = "/npc-details.jsp";
		
		if(detailsList.isEmpty()) {
			request.setAttribute("allNpcs", " ");
			System.out.println("list was empty");
			path = "/new-statblock.jsp";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//  Auto-generated method stub
		doGet(request, response);
	}

}
