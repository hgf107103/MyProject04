package Controller.RestaurantController.GuestController.TableController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.RestaurantModel.GuestDAO;
import Model.UserModel.UserVO;

@WebServlet("/Restaurant/Guest/OutTable")
public class OutTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.sendRedirect("/");
		} catch (Exception e) {
			response.sendRedirect("/View/JspError.jsp?nowErrorMessage=" + e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			
			HttpSession session = request.getSession();
			UserVO uv = (UserVO)session.getAttribute("mylogin");
			
			System.out.println("OUT TABLE SERVLET : START");
			System.out.println(request.getParameter("tableNumber"));
			System.out.println(uv.getId());
			
			GuestDAO gd = GuestDAO.getInstance();
			boolean check = gd.checkNowOrder(request.getParameter("tableNumber"));
			
			if (check) {
				
				boolean checkTwo = gd.tableOut(request.getParameter("tableNumber"));
				
				if (checkTwo) {
					PrintWriter out = response.getWriter();
					out.print("<head></head><body><script>alert('��ǵǾ����ϴ�.'); location.href = '/';</script></body>");
				} else {
					PrintWriter out = response.getWriter();
					out.print("<head></head><body><script>alert('��� �����ϼ̽��ϴ�.'); history.go(-1);</script></body>");
				}
				
			} else {
				PrintWriter out = response.getWriter();
				out.print("<head></head><body><script>alert('�������� ���� ������ �ֽ��ϴ�.'); history.go(-1);</script></body>");
			}
			
		} catch (Exception e) {
			response.sendRedirect("/View/JspError.jsp?nowErrorMessage=" + e);
		}
	}

}
