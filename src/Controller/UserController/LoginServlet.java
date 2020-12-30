package Controller.UserController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.UserModel.UserDAO;
import Model.UserModel.UserVO;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			RequestDispatcher rd = request.getRequestDispatcher("View/User/LoginView.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			response.sendRedirect("/");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			
			HttpSession session = request.getSession(true);
			
			UserDAO ud = UserDAO.getInstance();
			System.out.println("loginServlet : Created UserDTO");
			System.out.println(request.getParameter("id"));
			
			boolean check = ud.loginIdCheak(request.getParameter("id"));
			
			if (check) {
				UserVO nowLogin = ud.login(request.getParameter("id"), request.getParameter("pwd"));
				System.out.println("loginServlet : Created UserVO");
				
				if (nowLogin != null) {
					
					session.setAttribute("mylogin", nowLogin);
					PrintWriter out = response.getWriter();
					out.print("<head></head><body><script>alert('�α��� �Ǿ����ϴ�.'); location.href='/';</script></body>");
				
				} else {
					
					PrintWriter out = response.getWriter();
					System.out.println("�α��� ����");
					out.print("<head></head><body><script>alert('���̵�� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.'); history.go(-1);</script></body>");
				
				}
			} else {
				
				PrintWriter out = response.getWriter();
				System.out.println("�α��� ���� : ���̵��� ���翩�ΰ� ������");
				out.print("<head></head><body><script>alert('�������� �ʴ� ���̵��Դϴ�.'); history.go(-1);</script></body>");
			
			}
			
			
		} catch (Exception e) {
			response.sendRedirect("/");
		}
		
		
	}

}
