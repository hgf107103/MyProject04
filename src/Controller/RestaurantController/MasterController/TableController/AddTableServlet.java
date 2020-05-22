package Controller.RestaurantController.MasterController.TableController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.RestaurantModel.MasterDAO;
import Model.UserModel.UserVO;


@WebServlet("/Restaurant/Master/Table/AddTable")
public class AddTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			
			System.out.println("�߸��� ����Դϴ�.");
			 response.sendRedirect("/Restaurant/Master/Menu/ShowMenu");
			
		} catch (Exception e) {
			 System.out.println("doGet AddTable����");
			 response.sendRedirect("/View/JspError.jsp?nowErrorMessage=" + e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
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
			
			MasterDAO md = MasterDAO.getInstance();
			
			boolean check = md.addNewTable();
			
			if(check) {
				
				PrintWriter out = response.getWriter();
				out.print("<head></head><body><script>alert('���̺� �߰� �����߽��ϴ�.'); location.href = '/Restaurant/Master/Table/ShowTable?pageNumber=1';</script></body>");
				
			} else {
				System.out.println("���̺��߰� ���� ����");
				
				PrintWriter out = response.getWriter();
				out.print("<head></head><body><script>alert('���̺� �߰� �����߽��ϴ�.'); history.go(-1);</script></body>");
				return;
				
			}
			
			
			
		} catch (Exception e) {
			
			System.out.println("doGet AddTable����");
			 response.sendRedirect("/View/JspError.jsp?nowErrorMessage=" + e);
			 
		}
	}

}
