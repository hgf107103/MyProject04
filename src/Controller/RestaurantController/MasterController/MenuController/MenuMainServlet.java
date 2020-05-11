package Controller.RestaurantController.MasterController.MenuController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MenuMainServlet
 */
@WebServlet("/Restaurant/Master/Menu")
public class MenuMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			RequestDispatcher rd = request.getRequestDispatcher("/View/Restaurant/Master/Menu/MenuMainPage.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			 response.sendRedirect("/View/JspError.jsp?nowErrorMessage=" + e);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			RequestDispatcher rd = request.getRequestDispatcher("/View/Restaurant/Master/Menu/MenuMainPage.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			 response.sendRedirect("/View/JspError.jsp?nowErrorMessage=" + e);
		}
	}

}
