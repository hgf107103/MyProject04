package Controller.RestaurantController.MasterController.TableController;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.RestaurantModel.MasterDAO;
import Model.RestaurantModel.paymentDetailVO;
import Model.RestaurantModel.paymentHistoryVO;
import Model.UserModel.UserVO;

/**
 * Servlet implementation class PaymentDetailServlet
 */
@WebServlet("/Restaurant/Master/Table/PaymentDetail")
public class PaymentDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			if (request.getSession().getAttribute("mylogin") != null) {
				UserVO uv = (UserVO)request.getSession().getAttribute("mylogin");
				System.out.println("uv °ª : " + uv.getId());
				if(!uv.getId().equals("admin")) {
					response.sendRedirect("/View/JspError.jsp?nowErrorMessage=NullPointException");
					return;
				}
			} else {
				response.sendRedirect("/View/JspError.jsp?nowErrorMessage=NullPointException");
				return;
			}
			
			
			MasterDAO md = MasterDAO.getInstance();
			ArrayList<paymentDetailVO> list = md.showPaymentDetail(request.getParameter("payNumber"));
			
			SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
			Date payDetailDate = fm.parse(request.getParameter("payDate"));
			
			paymentHistoryVO pv = new paymentHistoryVO(payDetailDate, Integer.parseInt(request.getParameter("payNumber")), Integer.parseInt(request.getParameter("tableNumber")), request.getParameter("customersName"), request.getParameter("customersId"));
			pv.setPayTotal(Integer.parseInt(request.getParameter("payTotal")));
			
			request.setAttribute("payHistory", pv);
			request.setAttribute("payDetailList", list);
			
			RequestDispatcher rd = request.getRequestDispatcher("/View/Restaurant/Master/Table/PaymentDetailsPage.jsp");
			rd.forward(request, response);	
			
		} catch (Exception e) {
			System.out.println("paymentServlet ERROR : " + e);
			response.sendRedirect("/View/JspError.jsp?nowErrorMessage=NullpointException");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
