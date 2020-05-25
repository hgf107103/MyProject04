package Controller.RestaurantController.GuestController.OrderController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.RestaurantModel.GuestDAO;
import Model.RestaurantModel.MenuVO;


@WebServlet("/Restaurant/Guest/Order")
public class GuestOrderCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			
			GuestDAO gd = GuestDAO.getInstance();
			ArrayList<String> list = gd.getCategoryList();
			
			request.setAttribute("categoryList", list);
			
			RequestDispatcher rd = request.getRequestDispatcher("/View/Restaurant/Guest/Order/NewOrderPage.jsp");
			rd.forward(request, response);
			
			
		} catch (Exception e) {
			response.sendRedirect("/View/JspError.jsp?nowErrorMessage=" + e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			
			System.out.println(request.getParameter("categoryName"));
			
			GuestDAO gd = GuestDAO.getInstance();
			
			ArrayList<MenuVO> list = gd.showAllCategoryMenu(request.getParameter("categoryName"));
			
			request.setAttribute("categoryName", request.getParameter("categoryName"));
			request.setAttribute("menuList", list);
			
			RequestDispatcher rd = request.getRequestDispatcher("/View/Restaurant/Guest/Order/SelectOrderMenuPage.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			response.sendRedirect("/View/JspError.jsp?nowErrorMessage=" + e);
		}
	}

}
