package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StatBlock;

/**
 * Servlet implementation class AddStatblockServlet
 */
@WebServlet("/addStatblockServlet")
public class AddStatblockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStatblockServlet() {
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
		int strength = Integer.parseInt(request.getParameter("strength"));
		int dexterity = Integer.parseInt(request.getParameter("dexterity"));
		int constitution = Integer.parseInt(request.getParameter("constitution"));
		int intelligence = Integer.parseInt(request.getParameter("intelligence"));
		int wisdom = Integer.parseInt(request.getParameter("wisdom"));
		int charisma = Integer.parseInt(request.getParameter("charisma"));
		
		StatBlock stat = new StatBlock(strength,dexterity,constitution,intelligence,wisdom,charisma);
		StatBlockHelper dao = new StatBlockHelper();
		dao.insertStatBlock(stat);
		
		//send back to add another
		getServletContext().getRequestDispatcher("/new-statblock.jsp").forward(request, response);
		
	}

}
