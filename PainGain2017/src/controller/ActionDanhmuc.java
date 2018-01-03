package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import DAO.*;
import model.*;

/**
 * Servlet implementation class ActionDanhmuc
 */

public class ActionDanhmuc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActionDanhmuc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
    	response.setCharacterEncoding("utf-8");
    	
		int MaDM = Integer.parseInt(request.getParameter("MaDM"));
		DanhMucDAO db = new DanhMucDAO();
		String message ="";
		try
		{
			db.deleteDanhMuc(MaDM);
			message = "Xoá danh mục thành công.";
			RequestDispatcher xxx = request.getRequestDispatcher("DanhMucSP.jsp");
			request.setAttribute("msg", message );
			xxx.forward(request, response);
			
		}
		catch (Exception e)
		{
			message = "Xoá Khách hàng không thành công.";
			RequestDispatcher xxx = request.getRequestDispatcher("DanhMucSP.jsp");
			request.setAttribute("msg", message );
			xxx.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
    	response.setCharacterEncoding("utf-8");
    	String action = request.getParameter("action");
		DanhMucDAO db = new DanhMucDAO();
		
		String message ="";
		switch(action)
		{
		case "edit":
			try
			{
				int idd = Integer.parseInt(request.getParameter("ID"));
				String name = request.getParameter("Tendm");
				
	            
				DanhMuc kh = new DanhMuc(name);
	            try
	            {
	            	db.updateDanhMuc(idd, kh);
	            	
	            	message = "Sửa danh mục sản phẩm thành công.";
	            	RequestDispatcher xxx = request.getRequestDispatcher("DanhMucSP.jsp");
					request.setAttribute("msg1", message );
					xxx.forward(request, response);
	            	
	            }
	            catch(Exception e)
				{
	            	message = "Sửa danh mục sản phẩm không thành công 1.";
	            	RequestDispatcher xxx = request.getRequestDispatcher("DanhMucSP.jsp");
					request.setAttribute("msg1", message );
					xxx.forward(request, response);
				}
			}
			catch(Exception e)
			{
				message = "Sửa danh mục sản phẩm không thành công 2.";
	        	RequestDispatcher xxx = request.getRequestDispatcher("DanhMucSP.jsp");
				request.setAttribute("msg1", message );
				xxx.forward(request, response);
			}
			break;
		case "add":
			try
			{
				String name = request.getParameter("Tendm");
				
				
	            
				DanhMuc kh = new DanhMuc(name);
	            try
	            {
	            	db.insertDanhMuc(kh);
	            	
	            	message = "Thêm danh mục sản phẩm thành công.";
	            	RequestDispatcher xxx = request.getRequestDispatcher("DanhMucSP.jsp");
					request.setAttribute("msg1", message );
					xxx.forward(request, response);
	            	
	            }
	            catch(Exception e)
				{
	            	message = "Thêm danh mục sản phẩm không thành công 1.";
	            	RequestDispatcher xxx = request.getRequestDispatcher("DanhMucSP.jsp");
					request.setAttribute("msg1", message );
					xxx.forward(request, response);
				}
			}
			catch(Exception e)
			{
				message = "Thêm danh mục sản phẩm không thành công 2.";
	        	RequestDispatcher xxx = request.getRequestDispatcher("DanhMucSP.jsp");
				request.setAttribute("msg1", message );
				xxx.forward(request, response);
			}
			break;
		default:
			break;	
		}
	}

}
