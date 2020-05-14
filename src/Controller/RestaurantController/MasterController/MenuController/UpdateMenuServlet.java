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
			
			System.out.println("�޴� ���� ���� get�޼ҵ� ����");
			
			if (request.getParameter("updateMenuName") != null) {
				
				MasterDAO md = MasterDAO.getInstance();
				MenuVO mv = md.showOneMenu(request.getParameter("updateMenuName"));
				System.out.println("�޴� ���� ���� get�޼ҵ� MenuVO ��ü ������");
				
				if (mv != null) {
					System.out.println(mv);
					
					request.setAttribute("updateMenu", mv);
					RequestDispatcher rd = request.getRequestDispatcher("/View/Restaurant/Master/Menu/MenuUpdatePage.jsp");
					rd.forward(request, response);
				} else {
					PrintWriter out = response.getWriter();
					out.print("<head></head><body><script>alert('���� �ҷ����⿡ �����߽��ϴ�.'); history.go(-1);</script></body>");
				}
				
			} else {
				PrintWriter out = response.getWriter();
				out.print("<head></head><body><script>alert('���� �ҷ����⿡ �����߽��ϴ�.'); history.go(-1);</script></body>");
			}
			
			
		} catch (Exception e) {
			try {
				 System.out.println("doGet UpdateMenu����");
				 response.sendRedirect("/View/JspError.jsp?nowErrorMessage=" + e);
				
			} catch (Exception e2) {
				 System.out.println("doGet UpdateMenu����");
				 response.sendRedirect("/View/JspError.jsp?nowErrorMessage=" + e2);
			}
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			
			UserVO uv = (UserVO)request.getSession().getAttribute("mylogin");
			System.out.println("uv �� : " + uv.getId());
			if(!uv.getId().equals("admin")) {
				RequestDispatcher rd = request.getRequestDispatcher("/");
				rd.forward(request, response);
				return;
			}
			
			System.out.println("UpdateMenuServlet �۵�����");
			
			MasterDAO md = MasterDAO.getInstance();
			
			System.out.println(request.getParameter("menuNumber"));
			System.out.println(request.getParameter("menuName"));
			System.out.println(request.getParameter("menuCost"));
			System.out.println(request.getParameter("category"));
			
			
			MenuVO mv = MenuVO.getInstence(Integer.parseInt(request.getParameter("menuNumber")), request.getParameter("menuName"), Integer.parseInt(request.getParameter("menuCost")), md.checkCategory(request.getParameter("category")), request.getParameter("category"));
			
			if (md.isMenuDataChanged(mv)) {
				boolean updateCheak = md.updateMenu(mv);
				
				if (updateCheak) {
					
					System.out.println("�޴����� ���� ����");
					
					PrintWriter out = response.getWriter();
					out.print("<head></head><body><script>alert('�޴����� �����߽��ϴ�.'); self.close();</script></body>");
					
				} else {
					PrintWriter out = response.getWriter();
					out.print("<head></head><body><script>alert('�޴��߰� �����߽��ϴ�.'); history.go(-1);</script></body>");
					return;
				}
			} else {
				PrintWriter out = response.getWriter();
				out.print("<head></head><body><script>alert('�������� �ʾҽ��ϴ�.'); history.go(-1);</script></body>");
				return;
			}
			
			
			
		} catch (Exception e) {
			 System.out.println("doGet UpdateMenu����");
			 response.sendRedirect("/View/JspError.jsp?nowErrorMessage=" + e);
		}
	}

}
