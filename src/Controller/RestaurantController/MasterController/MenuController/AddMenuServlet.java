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
			 System.out.println("doGet AddMenu����");
			 response.sendRedirect("/View/JspError.jsp?nowErrorMessage=" + e);
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
			System.out.println("���� �̿� ����");
			
			String menuName = request.getParameter("menuName");
			System.out.println("�Ķ���� �� ���� : " + request.getParameter("menuName"));
			
			int menuCost = Integer.parseInt(request.getParameter("menuCost"));
			System.out.println("�Ķ���� �� ���� : " + request.getParameter("menuCost"));
			
			
			
			MasterDAO md = MasterDAO.getInstance();
			System.out.println("DTO����");
			
			int menuCategory = md.checkCategory(request.getParameter("category"));
			boolean nameCheck = md.addMenuNameCheck(menuName);
			
			if (nameCheck) {
				if(menuCategory > 0) {
					MenuVO mv = MenuVO.getInstence(menuName, menuCost, menuCategory);
					System.out.println("VO ����");
					
					boolean cheak = md.addNewMenu(mv);
					System.out.println("ADD����");
					
					if(cheak) {
						System.out.println("�޴��߰� ���� ����");
						
						PrintWriter out = response.getWriter();
						out.print("<head></head><body><script>alert('�޴��߰� �����߽��ϴ�.'); self.close();</script></body>");
						
					} else {
						System.out.println("�޴��߰� ���� ����");
						
						PrintWriter out = response.getWriter();
						out.print("<head></head><body><script>alert('�޴��߰� �����߽��ϴ�.'); history.go(-1);</script></body>");
						return;
						
					}
				} else {
					
					System.out.println("�޴��߰� ���� ī�װ� �ν� ����");
					
					PrintWriter out = response.getWriter();
					out.print("<head></head><body><script>alert('ī�װ��� �ν��� �� �����ϴ�.'); history.go(-1);</script></body>");
					return;
					
				}
			}else {
				
				System.out.println("���� �̸��� ���� �޴��� �̹� ������");
				
				PrintWriter out = response.getWriter();
				out.print("<head></head><body><script>alert('���� �̸��� �޴��� �ֽ��ϴ�.'); history.go(-1);</script></body>");
				return;
				
			}
			
			
			
			
			
		} catch (Exception e) {

			System.out.println("�޴��߰� ���� �����߻�");
			response.sendRedirect("/");
		}
	}

}
