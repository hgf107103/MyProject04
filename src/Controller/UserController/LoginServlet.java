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
					out.print("<head></head><body><script>alert('로그인 되었습니다.'); location.href='/';</script></body>");
				
				} else {
					
					PrintWriter out = response.getWriter();
					System.out.println("로그인 실패");
					out.print("<head></head><body><script>alert('아이디와 비밀번호가 일치하지 않습니다.'); history.go(-1);</script></body>");
				
				}
			} else {
				
				PrintWriter out = response.getWriter();
				System.out.println("로그인 실패 : 아이디의 존재여부가 부정됨");
				out.print("<head></head><body><script>alert('존재하지 않는 아이디입니다.'); history.go(-1);</script></body>");
			
			}
			
			
		} catch (Exception e) {
			response.sendRedirect("/");
		}
		
		
	}

}
