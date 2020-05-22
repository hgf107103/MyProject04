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
import Model.RestaurantModel.OrderVO;
import Model.UserModel.UserVO;

@WebServlet("/Restaurant/Guest/Payment")
public class GuestPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			
			GuestDAO gd = GuestDAO.getInstance();
			ArrayList<OrderVO> list = gd.getTableAllOrder(request.getParameter("tableNumber"));
			
			request.setAttribute("orderList", list);
			request.setAttribute("tableNumber", request.getParameter("tableNumber"));
			request.setAttribute("pageNumber", request.getParameter("pageNumber"));
			
			RequestDispatcher rd = request.getRequestDispatcher("/View/Restaurant/Guest/Order/OrderPaymentPage.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			response.sendRedirect("/View/JspError.jsp?nowErrorMessage=" + e);
		}
	}
	//전체내역 삭제
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			
			if (request.getSession().getAttribute("mylogin") != null) {
				UserVO uv = (UserVO)request.getSession().getAttribute("mylogin");
				System.out.println("게스트 서블릿 현재 로그인 : " + uv.getId());
			}
			
			
			System.out.println(request.getParameter("tableNumber"));
			System.out.println(request.getParameter("customersId"));
			System.out.println(request.getParameter("customersName"));
			
		} catch (Exception e) {
			System.out.println("CompletePaymentServlet ERROR : " + e);
			response.sendRedirect("/View/JspError.jsp?nowErrorMessage=" + e);
		}
	}

}
