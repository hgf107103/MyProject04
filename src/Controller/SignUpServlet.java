package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.UserDTO;
import Model.UserVO;


@WebServlet("/SignUp")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("View/User/SignUpView.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			
			if (request.getParameter("name") != null && request.getParameter("id") != null && request.getParameter("pwd") != null && request.getParameter("sex") != null) {
				
				UserVO uv = new UserVO(request.getParameter("name"), request.getParameter("id"), request.getParameter("pwd"), request.getParameter("sex"));
				
				UserDTO ud = UserDTO.getInstance();
				boolean cheak = ud.signUp(uv);
				
				if (cheak) {
					
					System.out.println("회원가입 서블릿 성공");
					
					PrintWriter out = response.getWriter();
					out.print("<head></head><body><script>alert('회원가입 성공했습니다.');</script></body>");
					
					RequestDispatcher rd = request.getRequestDispatcher("/Login");
					rd.forward(request, response);
					
				} else {
					PrintWriter out = response.getWriter();
					out.print("<head></head><body><script>alert('회원가입 실패했습니다.'); history.go(-1);</script></body>");
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
