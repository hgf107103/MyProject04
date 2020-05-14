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
 * Servlet implementation class DeleteMenuServlet
 */
@WebServlet("/Restaurant/Master/Menu/DeleteMenu")
public class DeleteMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			System.out.println("�߸��� ����Դϴ�.");
			 response.sendRedirect("/Restaurant/Master/Menu/ShowMenu");
			
		} catch (Exception e) {
			 System.out.println("doGet DeleteMenu����");
			 response.sendRedirect("/View/JspError.jsp?nowErrorMessage=" + e);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			int checkCnt = 0;
			
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			
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
			
			
			PrintWriter out = response.getWriter();
			
			System.out.println("�޴� ���� ���� �۵� ����");
			
			MenuVO mv = MenuVO.getInstence();
			
			if (request.getParameter("menuNumber") != null) {
				System.out.println("menuNumber : " + request.getParameter("menuNumber"));
				mv.setMenuNumber(Integer.parseInt(request.getParameter("menuNumber")));
				checkCnt++;
			}
			if (request.getParameter("menuName") != null) {
				System.out.println("menuName : " + request.getParameter("menuName"));
				mv.setMenuName(request.getParameter("menuName"));
				checkCnt++;
			}
			if (request.getParameter("menuCost") != null) {
				System.out.println("menuCost : " + request.getParameter("menuCost"));
				mv.setMenuCost(Integer.parseInt(request.getParameter("menuCost")));
				checkCnt++;
			}
			if (request.getParameter("categoryName") != null) {
				System.out.println("categoryName : " + request.getParameter("categoryName"));
				mv.setCategoryName(request.getParameter("categoryName"));
				checkCnt++;
			}
			if (request.getParameter("categoryNumber") != null) {
				System.out.println("categoryNumber : " + request.getParameter("categoryNumber"));
				mv.setCategoryNumber(Integer.parseInt(request.getParameter("categoryNumber")));
				checkCnt++;
			}
			
			System.out.println("Parameter Set Check Count : " + checkCnt);
			
			if (checkCnt == 5) {
				
				MasterDAO md = MasterDAO.getInstance();
				boolean deleteCheck = md.deleteMenu(mv);
				
				if (deleteCheck) {
					out.print("<script>alert('�޴� ��ȣ : "+ mv.getMenuNumber() + "\\n�޴� �̸� : " + mv.getMenuName() + "\\n�޴� ���� : " + mv.getMenuCost() + "��\\nī�װ� : " + mv.getCategoryName() + "\\n�޴��� �����Ǿ����ϴ�.'); </script>");
					out.print("<script>let backIndex = confirm('���� �������� ���ư��ðڽ��ϱ�?\\n��Ҹ� ������ â�� �����ϴ�.'); if(backIndex) { location.href='/Restaurant/Master/Menu/ShowMenu'; } else { self.close(); }</script>");
					return;
					
				} else {
					out.print("<script>alert('�޴� ������ �����Ͽ����ϴ�.');</script>");
					out.print("<script>history.go(-1);</script>");
				}
				
				
				
			} else {
				out.print("<script>alert('������ �����Ͱ� �־ ������ �߻��߽��ϴ�.');</script>");
				out.print("<script>history.go(-1);</script>");
			}
			
			
			
		} catch (Exception e) {
			 System.out.println("doPost DeleteMenu����");
			 response.sendRedirect("/View/JspError.jsp?nowErrorMessage=" + e);
		}
	}

}
