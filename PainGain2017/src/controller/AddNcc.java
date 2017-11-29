package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.*;

import model.*;

/**
 * Servlet implementation class AddNcc
 */

public class AddNcc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNcc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
    	response.setCharacterEncoding("utf-8");
		
		NhaCcDAO db = new NhaCcDAO();
		
		String message ="";
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
	}

}
