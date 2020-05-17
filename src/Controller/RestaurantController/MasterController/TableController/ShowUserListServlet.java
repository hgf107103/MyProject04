package Controller.RestaurantController.MasterController.TableController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.RestaurantModel.MasterDAO;
import Model.UserModel.UserDAO;
import Model.UserModel.UserVO;

/**
 * Servlet implementation class ShowUserListServlet
 */
@WebServlet("/Restaurant/Master/Table/ShowUser")
public class ShowUserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			
			UserDAO ud = UserDAO.getInstance();
			
			request.setAttribute("userList", ud.showAllUser());
			System.out.println(request.getAttribute("userList"));
			
			RequestDispatcher rd = request.getRequestDispatcher("/View/Restaurant/Master/Table/ShowUserPage.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			 System.out.println("doGet ShowMenu¿À·ù");
			 response.sendRedirect("/View/JspError.jsp?nowErrorMessage=" + e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
