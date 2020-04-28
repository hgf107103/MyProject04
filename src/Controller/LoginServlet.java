package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.jni.User;

import Model.UserDTO;
import Model.UserVO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("View/User/LoginView.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession(true);
		session.setMaxInactiveInterval(3600);
		
		UserDTO ud = UserDTO.getInstance();
		System.out.println(1);
		UserVO nowLogin = ud.login(request.getParameter("id"), request.getParameter("pwd"));
		System.out.println(2);
		if (nowLogin != null) {
			session.setAttribute("mylogin", nowLogin);
			RequestDispatcher rd = request.getRequestDispatcher("/");
			rd.forward(request, response);
		} else {
			PrintWriter out = response.getWriter();
			System.out.println("로그인 실패");
			out.print("<head></head><body><script>alert('아이디와 비밀번호가 일치하지 않습니다.'); history.go(-1);</script></body>");
		}
		
	}

}
