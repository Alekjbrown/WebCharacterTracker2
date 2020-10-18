package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewAllStatblocksServlet
 */
@WebServlet("/viewAllStatblocksServlet")
public class ViewAllStatblocksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllStatblocksServlet() {
        super();
        //  Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//  Auto-generated method stub
		StatBlockHelper dao = new StatBlockHelper();
		request.setAttribute("allStatBlocks", dao.getAll());
		String path = "/viewAllStats.jsp";
		
		if(dao.getAll().isEmpty()) {
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
