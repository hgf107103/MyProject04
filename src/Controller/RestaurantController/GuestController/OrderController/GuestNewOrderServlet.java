package Controller.RestaurantController.GuestController.OrderController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.RestaurantModel.GuestDAO;
import Model.RestaurantModel.OrderVO;

/**
 * Servlet implementation class GuestNewOrderServlet
 */
@WebServlet("/Restaurant/Guest/Order/NewOrder")
public class GuestNewOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
		} catch (Exception e) {
			response.sendRedirect("/View/JspError.jsp?nowErrorMessage=" + e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("NewOrder Start");
			
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			
			System.out.println(request.getParameter("orderName"));
			System.out.println(request.getParameter("orderCost"));
			System.out.println(request.getParameter("orderCount"));
			System.out.println(request.getParameter("newOrderCount"));//새 주문 카운터
			
			GuestDAO gd = GuestDAO.getInstance();
			
			boolean orderCheck = gd.checkOrderName(request.getParameter("tableNumber"), request.getParameter("orderName"));
			
			if (orderCheck) {
				
				System.out.println("NewOrder : 새로운 메뉴");
				
				boolean check = gd.newOrderPlus(request.getParameter("orderName"), request.getParameter("orderCost"), request.getParameter("newOrderCount"), request.getParameter("tableNumber"), request.getParameter("categoryNumber"));
				
				if (check) {
					
					PrintWriter out = response.getWriter();
					out.print("<head></head><body><script>alert('새 주문에 성공했습니다.'); location.href = '/Restaurant/Guest/Order?pageNumber=1&tableNumber=" + request.getParameter("tableNumber") + "';</script></body>");
				
				} else {
					
					PrintWriter out = response.getWriter();
					out.print("<head></head><body><script>alert('새 주문에 실패했습니다.'); history.go(-1);</script></body>");
				
				}
				
				
			} else {
				
				System.out.println("NewOrder : 이전 메뉴 추가 주문");
				
				boolean check = gd.oldOrderPlus(request.getParameter("newOrderCount"), request.getParameter("tableNumber"), request.getParameter("orderName"));
			
				if (check) {
					
					PrintWriter out = response.getWriter();
					out.print("<head></head><body><script>alert('추가 주문에 성공했습니다.'); location.href = '/Restaurant/Guest/Order?pageNumber=1&tableNumber=" + request.getParameter("tableNumber") + "';</script></body>");
				
				} else {
					
					PrintWriter out = response.getWriter();
					out.print("<head></head><body><script>alert('추가 주문에 실패했습니다.'); history.go(-1);</script></body>");
				
				}
			
			}
			
		} catch (Exception e) {
			response.sendRedirect("/View/JspError.jsp?nowErrorMessage=" + e);
		}
	}

}
