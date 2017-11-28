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

import DAO.AccountDAO;
import DAO.NhanVienDAO;
import model.Account;
import model.NhanVien;

/**
 * Servlet implementation class ActionNhanVien
 */

public class ActionNhanVien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActionNhanVien() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
    	response.setCharacterEncoding("utf-8");
		int MaNV = Integer.parseInt(request.getParameter("MaNV"));
		NhanVienDAO db = new NhanVienDAO();
		String message ="";
		try
		{
			db.deleteNhanVien(MaNV);
			message = "Xoá nhân viên thành công.";
			RequestDispatcher xxx = request.getRequestDispatcher("employee.jsp");
			request.setAttribute("msg", message );
			xxx.forward(request, response);
			
		}
		catch (Exception e)
		{
			message = "Xoá nhân viên không thành công.";
			RequestDispatcher xxx = request.getRequestDispatcher("employee.jsp");
			request.setAttribute("msg", message );
			xxx.forward(request, response);
		}
		
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
    	response.setCharacterEncoding("utf-8");
		
		NhanVienDAO db = new NhanVienDAO();
		AccountDAO db1 = new AccountDAO();
		String message ="";
		
			try
			{	
				int idd = Integer.parseInt(request.getParameter("ID"));
				String name = request.getParameter("Tennv");
				String username = request.getParameter("Username");
				String pass = request.getParameter("Password");
				
				String dc = request.getParameter("Diachi");
				//String ngayvl = request.getParameter("Date");
				
	            NhanVien nvo = new  NhanVienDAO().getNhanVienByID(idd);
	            
	            NhanVien nv = new NhanVien(name,nvo.getGioiTinh(),dc,nvo.getNgayVaoLam());
	            
	            Account acc = new Account(idd,username,pass);
	            try
	            {
	            	db.updateNhanVien(idd, nv);
	            	db1.updateAccount(idd, acc);
	            	message = "Chỉnh sủa nhân viên thành công.";
	            	RequestDispatcher xxx = request.getRequestDispatcher("employee.jsp");
					request.setAttribute("msg", message );
					xxx.forward(request, response);
	            	
	            }
	            catch(Exception e)
				{
	            	message = "Chỉnh sủa nhân viên không thành công 1.";
	            	RequestDispatcher xxx = request.getRequestDispatcher("employee.jsp");
					request.setAttribute("msg", message );
					xxx.forward(request, response);
				}
			}
			catch(Exception e)
			{
				message = "Chỉnh sủa nhân viên không thành công 2.";
            	RequestDispatcher xxx = request.getRequestDispatcher("employee.jsp");
				request.setAttribute("msg", message );
				xxx.forward(request, response);
			}
		
			
		
	}

}
