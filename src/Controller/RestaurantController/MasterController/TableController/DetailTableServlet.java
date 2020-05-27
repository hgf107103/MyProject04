package Controller.RestaurantController.MasterController.TableController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.RestaurantModel.MasterDAO;
import Model.RestaurantModel.OrderVO;
import Model.UserModel.UserVO;

/**
 * Servlet implementation class DetailTableServlet
 */
@WebServlet("/Restaurant/Master/Table/ShowTable/Detail")
public class DetailTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			ArrayList<OrderVO> list = md.showOneTableOrderList(request.getParameter("tableNumber"));
			
			request.setAttribute("tableNumber", request.getParameter("tableNumber"));
			request.setAttribute("orderList", list);
			request.getParameter("pageNumber");
			
			RequestDispatcher rd = request.getRequestDispatcher("/View/Restaurant/Master/Table/TableDetailPage.jsp?pageNumber=" + request.getParameter("pageNumber"));
			rd.forward(request, response);
			
		} catch (Exception e) {
			 System.out.println("doGet AddTable오류");
			 response.sendRedirect("/View/JspError.jsp?nowErrorMessage=" + e);
		}
	}
	
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
			ArrayList<OrderVO> list = md.showOneTableOrderList(request.getParameter("tableNumber"));
			
			request.setAttribute("tableNumber", request.getParameter("tableNumber"));
			request.setAttribute("orderList", list);
			request.getParameter("pageNumber");
			
			RequestDispatcher rd = request.getRequestDispatcher("/View/Restaurant/Master/Table/TableDetailPage.jsp?pageNumber=" + request.getParameter("pageNumber"));
			rd.forward(request, response);
			
		} catch (Exception e) {
			 System.out.println("doGet AddTable오류");
			 response.sendRedirect("/View/JspError.jsp?nowErrorMessage=" + e);
		}
	}

}
