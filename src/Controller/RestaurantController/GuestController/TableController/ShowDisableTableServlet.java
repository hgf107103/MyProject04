package Controller.RestaurantController.GuestController.TableController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.RestaurantModel.GuestDAO;
import Model.RestaurantModel.TableVO;
import Model.UserModel.UserVO;

/**
 * Servlet implementation class ShowDisableTableServlet
 */
@WebServlet("/Restaurant/Guest/DisableTable")
public class ShowDisableTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			
			HttpSession session = request.getSession();
			UserVO uv = (UserVO)session.getAttribute("mylogin");
			
			GuestDAO gd = GuestDAO.getInstance();
			
			ArrayList<TableVO> list = gd.getDisableTableList();
			request.setAttribute("tableList", list);
			
			RequestDispatcher rd = request.getRequestDispatcher("/View/Restaurant/Guest/Table/ShowDisableTablePage.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			System.out.println("DisableTable : ERROR - " + e);
			response.sendRedirect("/View/JspError.jsp?nowErrorMessage=" + e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			
			HttpSession session = request.getSession();
			UserVO uv = (UserVO)session.getAttribute("mylogin");
			
			System.out.println("SELECT TABLE SERVLET : START");
			System.out.println(request.getParameter("selectTableNumber"));
			System.out.println(uv.getId());
			
			GuestDAO gd = GuestDAO.getInstance();
			boolean check = gd.checkTable(uv.getId());
			
			if (check) {
				
				boolean selectTableCheck = gd.selectTable(uv, request.getParameter("selectTableNumber"));
				
				if (selectTableCheck) {
					PrintWriter out = response.getWriter();
					out.print("<head></head><body><script>alert('착석 성공했습니다.'); self.close(); window.opener.location.href='/Restaurant/Guest';</script></body>");
				}else {
					PrintWriter out = response.getWriter();
					out.print("<head></head><body><script>alert('착석실패했습니다.'); history.go(-1);</script></body>");
				}
				
				
			} else {
				PrintWriter out = response.getWriter();
				out.print("<head></head><body><script>alert('이미 착석해 있는 아이디 입니다.'); history.go(-1);</script></body>");
			}
			
		} catch (Exception e) {
			System.out.println("DisableTable : ERROR - " + e);
			response.sendRedirect("/View/JspError.jsp?nowErrorMessage=" + e);
		}
	}

}
