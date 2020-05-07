package Controller.RestaurantController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
		
			RequestDispatcher rd = request.getRequestDispatcher("View/Restaurant/Guest/GuestMain.jsp");
			rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			
			UserVO uv = (UserVO)request.getSession().getAttribute("mylogin");
			
			if(uv.getId().equals("admin")) {
				RequestDispatcher rd = request.getRequestDispatcher("View/Restaurant/Master/MasterMain.jsp");
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("View/Restaurant/Guest/GuestMain.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("View/Restaurant/Guest/GuestMain.jsp");
			rd.forward(request, response);
		}
		
		
		
	}

}
