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

import Model.UserModel.UserDTO;
import Model.UserModel.UserVO;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("View/User/LoginView.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession(true);
		
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
			System.out.println("�α��� ����");
			out.print("<head></head><body><script>alert('���̵�� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.'); history.go(-1);</script></body>");
		}
		
	}

}