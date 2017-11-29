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
 * Servlet implementation class ActionNcc
 */

public class ActionNcc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActionNcc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
    	response.setCharacterEncoding("utf-8");
		int MaKH = Integer.parseInt(request.getParameter("MaNCC"));
		NhaCcDAO db = new NhaCcDAO();
		String message ="";
		try
		{
			db.deleteNhaCc(MaKH);;
			message = "Xoá Nhà cung cấp thành công.";
			RequestDispatcher xxx = request.getRequestDispatcher("nhacc.jsp");
			request.setAttribute("msg", message );
			xxx.forward(request, response);
			
		}
		catch (Exception e)
		{
			message = "Xoá Nhà cung cấp không thành công.";
			RequestDispatcher xxx = request.getRequestDispatcher("nhacc.jsp");
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
		
    	NhaCcDAO db = new NhaCcDAO();
		String action = request.getParameter("action");
		String message ="";
		switch(action)
		{
		case "edit":
			try
			{
				int idd = Integer.parseInt(request.getParameter("ID"));
				String name = request.getParameter("Tennv");
				
				String pass = request.getParameter("Password");
				
				String dc = request.getParameter("Diachi");
				//String ngayvl = request.getParameter("Date");
				
				
	            
				NhaCc kh = new NhaCc(name,dc,pass);
	            try
	            {
	            	db.updateNhaCc(idd, kh);
	            	
	            	message = "Sửa Nhà cung cấp thành công.";
	            	RequestDispatcher xxx = request.getRequestDispatcher("nhacc.jsp");
					request.setAttribute("msg1", message );
					xxx.forward(request, response);
	            	
	            }
	            catch(Exception e)
				{
	            	message = "Sửa Nhà cung cấp không thành công 1.";
	            	RequestDispatcher xxx = request.getRequestDispatcher("nhacc.jsp");
					request.setAttribute("msg1", message );
					xxx.forward(request, response);
				}
			}
			catch(Exception e)
			{
				message = "Sửa Nhà cung cấp không thành công 2.";
	        	RequestDispatcher xxx = request.getRequestDispatcher("nhacc.jsp");
				request.setAttribute("msg1", message );
				xxx.forward(request, response);
			}
			
			break;
		case "add":
			try
			{
				String name = request.getParameter("Tennv");
				
				String pass = request.getParameter("Password");
				
				String dc = request.getParameter("Diachi");
				//String ngayvl = request.getParameter("Date");
				
				
	            
				NhaCc ncc = new NhaCc(name,dc,pass);
	            try
	            {
	            	db.insertNhaCc(ncc);
	            	
	            	message = "Thêm nhà cung cấp thành công.";
	            	RequestDispatcher xxx = request.getRequestDispatcher("nhacc.jsp");
					request.setAttribute("msg1", message );
					xxx.forward(request, response);
	            	
	            }
	            catch(Exception e)
				{
	            	message = "Thêm nhà cung cấp không thành công 1.";
	            	RequestDispatcher xxx = request.getRequestDispatcher("nhacc.jsp");
					request.setAttribute("msg1", message );
					xxx.forward(request, response);
				}
			}
			catch(Exception e)
			{
				message = "Thêm nhà cung cấp không thành công 2.";
	        	RequestDispatcher xxx = request.getRequestDispatcher("nhacc.jsp");
				request.setAttribute("msg1", message );
				xxx.forward(request, response);
			}
			break;
		default:
			break;
		}
			
	}

}
