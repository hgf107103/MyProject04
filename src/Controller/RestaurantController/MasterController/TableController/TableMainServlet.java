package Controller.RestaurantController.MasterController.TableController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TableMainServlet
 */
@WebServlet("/Restaurant/Master/Table")
public class TableMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			RequestDispatcher rd = request.getRequestDispatcher("/View/Restaurant/Master/Table/TableMainPage.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			try {
				response.sendRedirect("/View/JspError.jsp?nowErrorMessage=NullPointException");
			} catch (Exception e2) {
				response.sendRedirect("/View/JspError.jsp?nowErrorMessage=NullPointException");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			RequestDispatcher rd = request.getRequestDispatcher("/View/Restaurant/Master/Table/TableMainPage.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			try {
				response.sendRedirect("/View/JspError.jsp?nowErrorMessage=NullPointException");
			} catch (Exception e2) {
				response.sendRedirect("/View/JspError.jsp?nowErrorMessage=NullPointException");
			}
		}
	}

}
