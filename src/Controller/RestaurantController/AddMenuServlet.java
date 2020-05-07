package Controller.RestaurantController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.RestaurantModel.MasterDTO;
import Model.RestaurantModel.MenuVO;
import Model.UserModel.UserVO;


@WebServlet("/Restaurant/Master/AddMenu")
public class AddMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			RequestDispatcher rd = request.getRequestDispatcher("/View/Restaurant/Master/MasterMenuControll.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			 System.out.println("doGet AddMenu오류");
			 RequestDispatcher rd = request.getRequestDispatcher("/");
				rd.forward(request, response);
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
			
			MasterDTO md = MasterDTO.getInstance();
			System.out.println("DTO생성");
			
			MenuVO mv = MenuVO.getInstence(menuName, menuCost);
			System.out.println("VO 생성");
			
			boolean cheak = md.addNewMenu(mv);
			System.out.println("ADD성공");
			
			if(cheak) {
				System.out.println("메뉴추가 서블릿 성공");
				
				RequestDispatcher rd = request.getRequestDispatcher("/View/Restaurant/Master/MasterMain.jsp");
				rd.forward(request, response);
				
			} else {
				System.out.println("메뉴추가 서블릿 실패");
				
				PrintWriter out = response.getWriter();
				out.print("<head></head><body><script>alert('메뉴추가 실패했습니다.'); history.go(-1);</script></body>");
			}
			
			
		} catch (Exception e) {

			System.out.println("메뉴추가 서블릿 오류발생");
			response.sendRedirect("/");
		}
	}

}
