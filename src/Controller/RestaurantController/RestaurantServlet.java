package Controller.RestaurantController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.UserModel.UserVO;


@WebServlet("/Restaurant")
public class RestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			
			/*RequestDispatcher rd = request.getRequestDispatcher("/Restaurant/Guest");
			rd.forward(request, response);*/
			response.sendRedirect("/Restaurant/Guest");
		} catch (Exception e) {
			 response.sendRedirect("/View/JspError.jsp?nowErrorMessage=" + e);
		}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			response.sendRedirect("/Restaurant/Master");
			
			
			
		} catch (Exception e) {
			 response.sendRedirect("/View/JspError.jsp?nowErrorMessage=" + e);
		}
	}

}
