package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CaLamDAO;

import model.CaLam;


/**
 * Servlet implementation class ActionCalam
 */

public class ActionCalam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActionCalam() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
    	response.setCharacterEncoding("utf-8");
		int MaCa = Integer.parseInt(request.getParameter("MaCa"));
		CaLamDAO db = new CaLamDAO();
		String message ="";
		try
		{
			db.deleteCaLam(MaCa);
			message = "Xoá ca làm thành công.";
			RequestDispatcher xxx = request.getRequestDispatcher("calam.jsp");
			request.setAttribute("msg", message );
			xxx.forward(request, response);
			
		}
		catch (Exception e)
		{
			message = "Xoá ca làm không thành công.";
			RequestDispatcher xxx = request.getRequestDispatcher("calam.jsp");
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
    	SimpleDateFormat datefrmat = new SimpleDateFormat("HH:mm:ss");
    	CaLamDAO db = new CaLamDAO();
		String action = request.getParameter("action");
		String message ="";
		switch(action)
		{
		case "edit":
			try
			{
				int idd = Integer.parseInt(request.getParameter("ID"));
				String giobd = request.getParameter("egbd");
				
				String giokt = request.getParameter("egkt");
				
				int luong = Integer.parseInt(request.getParameter("eluong"));
				
	            
				CaLam kh = new CaLam(giobd,giokt,luong);
	            try
	            {
	            	db.updateCaLam(idd, kh);
	            	
	            	message = "Sửa ca làm thành công.";
	            	RequestDispatcher xxx = request.getRequestDispatcher("calam.jsp");
					request.setAttribute("msg", message );
					xxx.forward(request, response);
	            	
	            }
	            catch(Exception e)
				{
	            	message = "Sửa ca làm không thành công 1.";
	            	RequestDispatcher xxx = request.getRequestDispatcher("calam.jsp");
					request.setAttribute("msg", message );
					xxx.forward(request, response);
				}
			}
			catch(Exception e)
			{
				message = "Sửa ca làm không thành công 2.";
	        	RequestDispatcher xxx = request.getRequestDispatcher("calam.jsp");
				request.setAttribute("msg", message );
				xxx.forward(request, response);
			}
			
			break;
		case "add":
			try
			{
				String giobd = request.getParameter("agbd");
				
				String giokt = request.getParameter("agkt");
				
				int luong = Integer.parseInt(request.getParameter("aluong"));
	            
				CaLam kh = new CaLam(giobd,giokt,luong);
	            try
	            {
	            	db.insertCaLam(kh);
	            	
	            	message = "Thêm ca làm thành công.";
	            	RequestDispatcher xxx = request.getRequestDispatcher("calam.jsp");
					request.setAttribute("msg", message );
					xxx.forward(request, response);
	            	
	            }
	            catch(Exception e)
				{
	            	message = "Thêm ca làm không thành công 1.";
	            	RequestDispatcher xxx = request.getRequestDispatcher("calam.jsp");
					request.setAttribute("msg", message );
					xxx.forward(request, response);
				}
			}
			catch(Exception e)
			{
				message = "Thêm ca làm không thành công 2.";
	        	RequestDispatcher xxx = request.getRequestDispatcher("calam.jsp");
				request.setAttribute("msg", message );
				xxx.forward(request, response);
			}
			break;
		default:
			break;
		}
	}

}
