package Controller.RestaurantController.GuestController.TableController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/CompletePaymentServlet")
public class CompletePaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			response.sendRedirect("/View/JspError.jsp?nowErrorMessage=NullPointException");
			
		} catch (Exception e) {
			System.out.println("CompletePaymentServlet ERROR : " + e);
			response.sendRedirect("/View/JspError.jsp?nowErrorMessage=" + e);
		}
	}

	//내역 하나씩 삭제
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			
			HttpSession session = request.getSession();
			
			
		} catch (Exception e) {
			System.out.println("CompletePaymentServlet ERROR : " + e);
			response.sendRedirect("/View/JspError.jsp?nowErrorMessage=" + e);
		}
	}

}
