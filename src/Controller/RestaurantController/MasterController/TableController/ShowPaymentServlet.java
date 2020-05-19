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
import Model.RestaurantModel.paymentHistoryVO;
import Model.UserModel.UserVO;

@WebServlet("/Restaurant/Master/Table/ShowPayment")
public class ShowPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			if (request.getSession().getAttribute("mylogin") != null) {
				UserVO uv = (UserVO)request.getSession().getAttribute("mylogin");
				System.out.println("uv �� : " + uv.getId());
				if(!uv.getId().equals("admin")) {
					response.sendRedirect("/View/JspError.jsp?nowErrorMessage=NullPointException");
					return;
				}
			} else {
				response.sendRedirect("/View/JspError.jsp?nowErrorMessage=NullPointException");
				return;
			}
			
			
			MasterDAO md = MasterDAO.getInstance();
			ArrayList<paymentHistoryVO> list = md.showAllPaymentHistory("t1.payNumber", "ASC");
			
			request.setAttribute("paymentList", list);
			
			RequestDispatcher rd = request.getRequestDispatcher("/View/Restaurant/Master/Table/PaymentHistoryPage.jsp");
			rd.forward(request, response);	
			
		} catch (Exception e) {
			System.out.println("paymentServlet ERROR : " + e);
			response.sendRedirect("/View/JspError.jsp?nowErrorMessage=NullpointException");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			if (request.getSession().getAttribute("mylogin") != null) {
				UserVO uv = (UserVO)request.getSession().getAttribute("mylogin");
				System.out.println("uv �� : " + uv.getId());
				if(!uv.getId().equals("admin")) {
					response.sendRedirect("/View/JspError.jsp?nowErrorMessage=NullPointException");
					return;
				}
			} else {
				response.sendRedirect("/View/JspError.jsp?nowErrorMessage=NullPointException");
				return;
			}
			
			System.out.println("���� : " + request.getParameter("listSortOrderBy"));
			System.out.println("�ʵ� : " + request.getParameter("listSort"));
			
			MasterDAO md = MasterDAO.getInstance();
			ArrayList<paymentHistoryVO> list = md.showAllPaymentHistory(request.getParameter("listSort"), request.getParameter("listSortOrderBy"));
			
			request.setAttribute("selectName", request.getParameter("listSort"));
			request.setAttribute("selectSort", request.getParameter("listSortOrderBy"));
			request.setAttribute("paymentList", list);
			
			RequestDispatcher rd = request.getRequestDispatcher("/View/Restaurant/Master/Table/PaymentHistoryPage.jsp");
			rd.forward(request, response);	
			
		} catch (Exception e) {
			System.out.println("paymentServlet ERROR : " + e);
			response.sendRedirect("/View/JspError.jsp?nowErrorMessage=NullpointException");
		}
	}

}
