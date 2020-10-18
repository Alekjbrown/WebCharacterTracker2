package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddNPCDetailsServlet
 */
@WebServlet("/addNPCDetailServlet")
public class AddNPCDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNPCDetailServlet() {
        super();
        //  Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//  Auto-generated method stub
		StatBlockHelper sbh = new StatBlockHelper();
		
		request.setAttribute("allStatblocks", sbh.getAll());
		
		if(sbh.getAll().isEmpty()) {
			request.setAttribute("allStatblocks", " ");
		}
		
		getServletContext().getRequestDispatcher("/new-npc-details.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//  Auto-generated method stub
		doGet(request, response);
	}

}
