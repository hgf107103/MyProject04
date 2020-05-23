package Controller.RestaurantController.GuestController.TableController;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.RestaurantModel.GuestDAO;
import Model.RestaurantModel.OrderVO;
import Model.RestaurantModel.paymentDetailVO;
import Model.RestaurantModel.paymentHistoryVO;
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
	//��ü���� ����
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			
			System.out.println("GuestPaymentServlet : START");
			
			
			UserVO uv = (UserVO)request.getSession().getAttribute("mylogin");
			System.out.println("�Խ�Ʈ ���� ���� �α��� : " + uv.getId());
			
			System.out.println(request.getParameter("tableNumber"));
			System.out.println(request.getParameter("customersId"));
			System.out.println(request.getParameter("customersName"));
			
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = sf.parse(sf.format(new Date()));
			
			System.out.println("���� ��¥ : " + date);
			
			GuestDAO gd = GuestDAO.getInstance();
			
			int payNumber = gd.getTodayPayNumber();
			System.out.println(payNumber);
			
			paymentHistoryVO payHis = new paymentHistoryVO(date, payNumber, Integer.parseInt(request.getParameter("tableNumber")), request.getParameter("customersName"), request.getParameter("customersId"));
			
			boolean check = gd.SaveGuestPaymentHistory(payHis);
			
			if (check) {
				
				System.out.println("�����丮 ���� �Ϸ�");
				
				ArrayList<paymentDetailVO> list = gd.GetPaymentDetailList(request.getParameter("tableNumber"), payNumber);
				
				boolean checkDetail = gd.SaveGuestPaymentDetail(list);
				
				if (checkDetail) {
					
					System.out.println("������ ���� �Ϸ�");
					
					boolean checkOrderDelete = gd.CompletePayment(request.getParameter("tableNumber"));
					
					if (checkOrderDelete) {
						System.out.println("���� ���� ����");
						System.out.println("������ �Ϸ�Ǿ����ϴ�.");
						
						PrintWriter out = response.getWriter();
						out.print("<head></head><body><script>alert('�����Ǿ����ϴ�'); self.close();</script></body>");
						
						
					}	else {
						
						System.out.println("���� ���� ����");
						PrintWriter out = response.getWriter();
						out.print("<head></head><body><script>alert('�ֹ����� ������ �����Ͽ����ϴ�.'); history.go(-1);</script></body>");
					
					}
					
				}	else {
					
					System.out.println("������ ���� ����");
					PrintWriter out = response.getWriter();
					out.print("<head></head><body><script>alert('�� ���� ���忡 �����Ͽ����ϴ�.'); history.go(-1);</script></body>");
				
				}
				
				
			} else {
				
				System.out.println("�����丮 ���� ����");
				PrintWriter out = response.getWriter();
				out.print("<head></head><body><script>alert('���� ���忡 �����Ͽ����ϴ�.'); history.go(-1);</script></body>");
			
			}
			
			
		} catch (Exception e) {
			System.out.println("CompletePaymentServlet ERROR : " + e);
			response.sendRedirect("/View/JspError.jsp?nowErrorMessage=" + e);
		}
	}

}
