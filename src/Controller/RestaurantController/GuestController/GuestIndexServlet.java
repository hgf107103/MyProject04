package Controller.RestaurantController.GuestController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.RestaurantModel.GuestDAO;
import Model.RestaurantModel.TableVO;
import Model.UserModel.UserVO;

@WebServlet("/Restaurant/Guest")
public class GuestIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			if (request.getSession().getAttribute("mylogin") != null) {
				UserVO uv = (UserVO)request.getSession().getAttribute("mylogin");
				System.out.println("게스트 서블릿 현재 로그인 : " + uv.getId());
				GuestDAO gd = GuestDAO.getInstance();
				
				TableVO tv = gd.getGuestTable(uv.getId());
				
				request.setAttribute("nowLoginVO", uv);
				
				
				if (tv != null) {
					request.setAttribute("nowTable", tv);
					
					RequestDispatcher rd = request.getRequestDispatcher("/View/Restaurant/Guest/GuestMainPage.jsp");
					rd.forward(request, response);
				} else {
					RequestDispatcher rd = request.getRequestDispatcher("/View/Restaurant/Guest/NoTableGuestMain.jsp");
					rd.forward(request, response);
				}
				
				
			} else {
				response.sendRedirect("/View/JspError.jsp?nowErrorMessage=Not Login");
				return;
			}
			
			
		} catch (Exception e) {
			response.sendRedirect("/View/JspError.jsp?nowErrorMessage=" + e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			RequestDispatcher rd = request.getRequestDispatcher("/View/Restaurant/Guest/GuestMainPage.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			response.sendRedirect("/View/JspError.jsp?nowErrorMessage=" + e);
		}
	}

}
