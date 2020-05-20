package Controller.RestaurantController.MasterController.TableController;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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
			
			ArrayList<paymentHistoryVO> list = md.showAllPaymentHistory("t1.payNumber", "DESC");
			
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
				System.out.println("uv 값 : " + uv.getId());
				if(!uv.getId().equals("admin")) {
					response.sendRedirect("/View/JspError.jsp?nowErrorMessage=NullPointException");
					return;
				}
			} else {
				response.sendRedirect("/View/JspError.jsp?nowErrorMessage=NullPointException");
				return;
			}
			
			System.out.println("정렬 : " + request.getParameter("listSortOrderBy"));
			System.out.println("필드 : " + request.getParameter("listSort"));
			System.out.println("날짜 : " + request.getParameter("listDay"));
	        
			MasterDAO md = MasterDAO.getInstance();
			ArrayList<paymentHistoryVO> list = null;
			
			Calendar cal = Calendar.getInstance();
	        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	        Date date = new Date();
	        cal.setTime(date);
	        System.out.println("ShowPaymentServlet : 날짜 세트");
	        
	        switch (request.getParameter("listDay")) {
				case "dateAll": {
					list = md.showAllPaymentHistory(request.getParameter("listSort"), request.getParameter("listSortOrderBy"));
					break;
				}
				case "dateToday": {
					list = md.showSetTimePaymentHistory(request.getParameter("listSort"), request.getParameter("listSortOrderBy"), df.format(date));
					break;
				}
				case "dateWeek": {
					cal.add(Calendar.DAY_OF_WEEK_IN_MONTH, -1);
					list = md.showSetTimePaymentHistory(request.getParameter("listSort"), request.getParameter("listSortOrderBy"), df.format(cal.getTime()));
					break;
				}
				case "dateMonth": {
					cal.add(Calendar.MONTH, -1);
					list = md.showSetTimePaymentHistory(request.getParameter("listSort"), request.getParameter("listSortOrderBy"), df.format(cal.getTime()));
					break;
				}
				case "dateYear": {
					cal.add(Calendar.YEAR, -1);
					list = md.showSetTimePaymentHistory(request.getParameter("listSort"), request.getParameter("listSortOrderBy"), df.format(cal.getTime()));
					break;
				}
				default: {
					list = md.showAllPaymentHistory(request.getParameter("listSort"), request.getParameter("listSortOrderBy"));
					break;
				}
			}
			
			request.setAttribute("selectName", request.getParameter("listSort"));
			request.setAttribute("selectSort", request.getParameter("listSortOrderBy"));
			request.setAttribute("selectDay", request.getParameter("listDay"));
			request.setAttribute("paymentList", list);
			
			RequestDispatcher rd = request.getRequestDispatcher("/View/Restaurant/Master/Table/PaymentHistoryPage.jsp");
			rd.forward(request, response);	
			
		} catch (Exception e) {
			System.out.println("paymentServlet ERROR : " + e);
			response.sendRedirect("/View/JspError.jsp?nowErrorMessage=NullpointException");
		}
	}

}
