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

public class ActionLoaisp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActionLoaisp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
    	response.setCharacterEncoding("utf-8");
    	
		int MaLSP = Integer.parseInt(request.getParameter("MaLSP"));
		LoaiSpDAO db = new LoaiSpDAO();
		String message ="";
		try
		{
			db.deleteLoaiSp(MaLSP);;
			message = "Xoá loại sản phẩm thành công.";
			RequestDispatcher xxx = request.getRequestDispatcher("LoaiSP.jsp");
			request.setAttribute("msg", message );
			xxx.forward(request, response);
			
		}
		catch (Exception e)
		{
			message = "Xoá loại sản phẩm không thành công.";
			RequestDispatcher xxx = request.getRequestDispatcher("LoaiSP.jsp");
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
    	LoaiSpDAO db = new LoaiSpDAO();
		
		String message ="";
		switch(action)
		{
		case "edit":
			try
			{
				int idd = Integer.parseInt(request.getParameter("ID"));
				String name = request.getParameter("Tenlsp");
				int idDM = Integer.parseInt(request.getParameter("MaDM"));
	            
				LoaiSp kh = new LoaiSp(name,idDM);
	            try
	            {
	            	db.updateLoaiSp(idd, kh);
	            	
	            	message = "Sửa loại sản phẩm thành công.";
	            	RequestDispatcher xxx = request.getRequestDispatcher("LoaiSP.jsp");
					request.setAttribute("msg1", message );
					xxx.forward(request, response);
	            	
	            }
	            catch(Exception e)
				{
	            	message = "Sửa danh mục sản phẩm không thành công 1.";
	            	RequestDispatcher xxx = request.getRequestDispatcher("LoaiSP.jsp");
					request.setAttribute("msg1", message );
					xxx.forward(request, response);
				}
			}
			catch(Exception e)
			{
				message = "Sửa loại sản phẩm không thành công 2.";
	        	RequestDispatcher xxx = request.getRequestDispatcher("LoaiSP.jsp");
				request.setAttribute("msg1", message );
				xxx.forward(request, response);
			}
			break;
		case "add":
			try
			{
				
				String name = request.getParameter("Tenlsp");
				int idDM = Integer.parseInt(request.getParameter("MaDM"));
	            
				LoaiSp kh = new LoaiSp(name,idDM);
	            try
	            {
	            	db.insertLoaiSp(kh);;
	            	
	            	message = "Thêm loại sản phẩm thành công.";
	            	RequestDispatcher xxx = request.getRequestDispatcher("LoaiSP.jsp");
					request.setAttribute("msg1", message );
					xxx.forward(request, response);
	            	
	            }
	            catch(Exception e)
				{
	            	message = "Thêm loại sản phẩm không thành công 1.";
	            	RequestDispatcher xxx = request.getRequestDispatcher("LoaiSP.jsp");
					request.setAttribute("msg1", message );
					xxx.forward(request, response);
				}
			}
			catch(Exception e)
			{
				message = "Thêm loại sản phẩm không thành công 2.";
	        	RequestDispatcher xxx = request.getRequestDispatcher("LoaiSP.jsp");
				request.setAttribute("msg1", message );
				xxx.forward(request, response);
			}
			break;
		default:
			break;	
		}
	}

}
