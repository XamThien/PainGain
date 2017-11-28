package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.KhachHangDAO;
import DAO.NhanVienDAO;
import model.KhachHang;

/**
 * Servlet implementation class ActionKhachHang
 */

public class ActionKhachHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActionKhachHang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
    	response.setCharacterEncoding("utf-8");
		int MaKH = Integer.parseInt(request.getParameter("MaKH"));
		NhanVienDAO db = new NhanVienDAO();
		String message ="";
		try
		{
			db.deleteNhanVien(MaKH);
			message = "Xoá Khách hàng thành công.";
			RequestDispatcher xxx = request.getRequestDispatcher("KhachHang.jsp");
			request.setAttribute("msg", message );
			xxx.forward(request, response);
			
		}
		catch (Exception e)
		{
			message = "Xoá Khách hàng không thành công.";
			RequestDispatcher xxx = request.getRequestDispatcher("KhachHang.jsp");
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
		
		KhachHangDAO db = new KhachHangDAO();
		
		String message ="";
		try
		{
			int idd = Integer.parseInt(request.getParameter("ID"));
			String name = request.getParameter("Tennv");
			
			String pass = request.getParameter("Password");
			
			String dc = request.getParameter("Diachi");
			//String ngayvl = request.getParameter("Date");
			
			
            
			KhachHang kh = new KhachHang(name,pass,dc);
            try
            {
            	db.updateKhachHang(idd, kh);
            	
            	message = "Sửa Khách hàng thành công.";
            	RequestDispatcher xxx = request.getRequestDispatcher("KhachHang.jsp");
				request.setAttribute("msg1", message );
				xxx.forward(request, response);
            	
            }
            catch(Exception e)
			{
            	message = "Sửa Khách hàng không thành công 1.";
            	RequestDispatcher xxx = request.getRequestDispatcher("KhachHang.jsp");
				request.setAttribute("msg1", message );
				xxx.forward(request, response);
			}
		}
		catch(Exception e)
		{
			message = "Sửa Khách hàng không thành công 2.";
        	RequestDispatcher xxx = request.getRequestDispatcher("KhachHang.jsp");
			request.setAttribute("msg1", message );
			xxx.forward(request, response);
		}
	}

}
