package Controller.RestaurantController.MasterController.TableController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.RestaurantModel.MasterDAO;
import Model.UserModel.UserVO;

/**
 * Servlet implementation class DeleteTableServlet
 */
@WebServlet("/Restaurant/Master/Table/DeleteTable")
public class DeleteTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			
			System.out.println("잘못된 경로입니다.");
			 response.sendRedirect("/Restaurant/Master/Menu/ShowMenu");
			
		} catch (Exception e) {
			 System.out.println("doGet AddTable오류");
			 response.sendRedirect("/View/JspError.jsp?nowErrorMessage=" + e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			
			if (request.getSession().getAttribute("mylogin") != null) {
				UserVO uv = (UserVO)request.getSession().getAttribute("mylogin");
				System.out.println("uv 값 : " + uv.getId());
				if(!uv.getId().equals("admin")) {
					response.sendRedirect("/View/JspError.jsp?nowErrorMessage=NullPointException");
					return;
				}
			} else {
				response.sendRedirect("/View/JspError.jsp?nowErrorMessage=NullPointException");
				return;
			}
			
			MasterDAO md = MasterDAO.getInstance();
			
			boolean check = md.deleteTable();
			
			if(check) {
				
				PrintWriter out = response.getWriter();
				out.print("<head></head><body><script>alert('테이블 삭제 성공했습니다.'); location.href = '/Restaurant/Master/Table/ShowTable';</script></body>");
				
			} else {
				System.out.println("테이블추가 서블릿 실패");
				
				PrintWriter out = response.getWriter();
				out.print("<head></head><body><script>alert('테이블 삭제 실패했습니다.\\n마지막 테이블에 손님이 있으면 삭제되지 않습니다.'); history.go(-1);</script></body>");
				return;
				
			}
			
			
			
		} catch (Exception e) {
			
			System.out.println("doGet AddTable오류");
			 response.sendRedirect("/View/JspError.jsp?nowErrorMessage=" + e);
			 
		}
	}

}
