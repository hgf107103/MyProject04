package Controller.RestaurantController.MasterController.MenuController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.RestaurantModel.MasterDAO;


@WebServlet("/Restaurant/Master/Menu/ShowMenu")
public class ShowMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			MasterDAO md = MasterDAO.getInstance();
			
			request.setAttribute("menuList", md.showAllMenu());
			System.out.println(request.getAttribute("menuList"));
			
			RequestDispatcher rd = request.getRequestDispatcher("/View/Restaurant/Master/Menu/ShowMenuPage.jsp");
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
