package Controller.RestaurantController.MasterController.MenuController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.RestaurantModel.MasterDAO;
import Model.RestaurantModel.MenuVO;

/**
 * Servlet implementation class UpdateMenuServlet
 */
@WebServlet("/Restaurant/Master/Menu/UpdateMenu")
public class UpdateMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			
			System.out.println("메뉴 수정 서블릿 get메소드 시작");
			
			if (request.getParameter("updateMenuName") != null) {
				
				MasterDAO md = MasterDAO.getInstance();
				MenuVO mv = md.showOneMenu(request.getParameter("updateMenuName"));
				System.out.println("메뉴 수정 서블릿 get메소드 MenuVO 객체 생성됨");
				
				if (mv != null) {
					System.out.println(mv);
					
					request.setAttribute("updateMenu", mv);
					RequestDispatcher rd = request.getRequestDispatcher("/View/Restaurant/Master/Menu/MenuUpdatePage.jsp");
					rd.forward(request, response);
				} else {
					PrintWriter out = response.getWriter();
					out.print("<head></head><body><script>alert('정보 불러오기에 실패했습니다.'); history.go(-1);</script></body>");
				}
				
			} else {
				PrintWriter out = response.getWriter();
				out.print("<head></head><body><script>alert('정보 불러오기에 실패했습니다.'); history.go(-1);</script></body>");
			}
			
			
		} catch (Exception e) {
			try {
				 System.out.println("doGet UpdateMenu오류");
				 response.sendRedirect("/View/JspError.jsp?nowErrorMessage=" + e);
				
			} catch (Exception e2) {
				 System.out.println("doGet UpdateMenu오류");
				 response.sendRedirect("/View/JspError.jsp?nowErrorMessage=" + e2);
			}
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
