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
			
			UserVO nowLogin = ud.login(request.getParameter("id"), request.getParameter("pwd"));
			System.out.println("loginServlet : Created UserVO");
			
			if (nowLogin != null) {
				session.setAttribute("mylogin", nowLogin);
				/*RequestDispatcher rd = request.getRequestDispatcher("/");
				rd.forward(request, response);*/
				response.sendRedirect("/");
			} else {
				PrintWriter out = response.getWriter();
				System.out.println("로그인 실패");
				out.print("<head></head><body><script>alert('아이디와 비밀번호가 일치하지 않습니다.'); history.go(-1);</script></body>");
			}
		} catch (Exception e) {
			response.sendRedirect("/");
		}
		
		
	}

}
