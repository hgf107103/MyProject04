package Controller.RestaurantController.MasterController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MasterIndexServlet
 */
@WebServlet("/Restaurant/Master")
public class MasterIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			RequestDispatcher rd = request.getRequestDispatcher("/View/Restaurant/Master/MasterMain.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			response.sendRedirect("/");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			RequestDispatcher rd = request.getRequestDispatcher("/View/Restaurant/Master/MasterMain.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			response.sendRedirect("/");
		}
	}

}
