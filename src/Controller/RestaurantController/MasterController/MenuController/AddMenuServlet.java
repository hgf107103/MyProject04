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
import Model.UserModel.UserVO;


@WebServlet("/Restaurant/Master/Menu/AddMenu")
public class AddMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			RequestDispatcher rd = request.getRequestDispatcher("/View/Restaurant/Master/Menu/MenuAddPage.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			 System.out.println("doGet AddMenu오류");
			 response.sendRedirect("/View/JspError.jsp?nowErrorMessage=" + e);
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			
			UserVO uv = (UserVO)request.getSession().getAttribute("mylogin");
			System.out.println("uv 값 : " + uv.getId());
			if(!uv.getId().equals("admin")) {
				RequestDispatcher rd = request.getRequestDispatcher("/");
				rd.forward(request, response);
				return;
			}
			System.out.println("어드민 이외 퇴출");
			
			String menuName = request.getParameter("menuName");
			System.out.println("파라미터 값 저장 : " + request.getParameter("menuName"));
			
			int menuCost = Integer.parseInt(request.getParameter("menuCost"));
			System.out.println("파라미터 값 저장 : " + request.getParameter("menuCost"));
			
			
			
			MasterDAO md = MasterDAO.getInstance();
			System.out.println("DTO생성");
			
			int menuCategory = md.checkCategory(request.getParameter("category"));
			boolean nameCheck = md.addMenuNameCheck(menuName);
			
			if (nameCheck) {
				if(menuCategory > 0) {
					MenuVO mv = MenuVO.getInstence(menuName, menuCost, menuCategory);
					System.out.println("VO 생성");
					
					boolean cheak = md.addNewMenu(mv);
					System.out.println("ADD성공");
					
					if(cheak) {
						System.out.println("메뉴추가 서블릿 성공");
						
						PrintWriter out = response.getWriter();
						out.print("<head></head><body><script>alert('메뉴추가 성공했습니다.'); self.close();</script></body>");
						
					} else {
						System.out.println("메뉴추가 서블릿 실패");
						
						PrintWriter out = response.getWriter();
						out.print("<head></head><body><script>alert('메뉴추가 실패했습니다.'); history.go(-1);</script></body>");
						return;
						
					}
				} else {
					
					System.out.println("메뉴추가 서블릿 카테고리 인식 실패");
					
					PrintWriter out = response.getWriter();
					out.print("<head></head><body><script>alert('카테고리를 인식할 수 없습니다.'); history.go(-1);</script></body>");
					return;
					
				}
			}else {
				
				System.out.println("같은 이름을 가진 메뉴가 이미 존재함");
				
				PrintWriter out = response.getWriter();
				out.print("<head></head><body><script>alert('같은 이름의 메뉴가 있습니다.'); history.go(-1);</script></body>");
				return;
				
			}
			
			
			
			
			
		} catch (Exception e) {

			System.out.println("메뉴추가 서블릿 오류발생");
			response.sendRedirect("/");
		}
	}

}
