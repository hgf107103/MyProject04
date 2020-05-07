package Controller.UserController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.UserModel.UserDTO;


@WebServlet("/IdCheak")
public class SignUpCheakIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/index.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			
			String URL = "View/User/SignUpPopUp.jsp?id=" + request.getParameter("popId");
			
			UserDTO ud = UserDTO.getInstance();

			boolean idCheak =  ud.idCheak(request.getParameter("popId"));
			
			if (idCheak) {
				URL = URL + "&isIdCheakd=cheakok";
				response.sendRedirect(URL);
			} else {
				URL = URL + "&isIdCheakd=cheakno";
				response.sendRedirect(URL);
			}
			
		} catch (Exception e) {
			System.out.println("아이디 중복검사 팝업 오류발생");
		}
	}

}
