package Controller.RestaurantController.GuestController.TableController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.RestaurantModel.GuestDAO;
import Model.RestaurantModel.TableVO;
import Model.UserModel.UserVO;

/**
 * Servlet implementation class ShowDisableTableServlet
 */
@WebServlet("/Restaurant/Guest/DisableTable")
public class ShowDisableTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			UserVO uv = (UserVO)session.getAttribute("mylogin");
			
			GuestDAO gd = GuestDAO.getInstance();
			
			ArrayList<TableVO> list = gd.getDisableTableList();
			request.setAttribute("tableList", list);
			
			RequestDispatcher rd = request.getRequestDispatcher("/View/Restaurant/Guest/Table/ShowDisableTablePage.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			System.out.println("DisableTable : ERROR - " + e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
