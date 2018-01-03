package controller.banhang;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.KhachHang;
import DAO.KhachHangDAO;


/**
 * Servlet implementation class AddNewCustomer
 */
@WebServlet("/addcustomer")
public class AddNewCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset= UTF-8");
		request.setCharacterEncoding("utf-8");
		 try
		 {

		String TenHK =request.getParameter("TenKH");
		 String DiaChi =request.getParameter("Address");
		 String SoDT =request.getParameter("SDT");
		 
		 
		 KhachHang kh = new KhachHang(TenHK, DiaChi, SoDT);
		 KhachHangDAO db = new KhachHangDAO();
		 
		 String message = "";
		 try 
		 {
			 if (TenHK !="" && DiaChi!= "" && SoDT!=""  )
			 {
				 try
				 {
					 db.insertKhachHang(kh);
					 response.getWriter().println("Thêm thành công");
				 }
				 catch (Exception ex)
				 {
					 response.getWriter().println("Không thành công! Kiểm tra lại thông tin");
				 }
			 }
			 else 
			 {
				 response.getWriter().println("Không thành công! Kiểm tra lại thông tin");
			 }
		 } catch (Exception e) {
			response.getWriter().println("Lỗi: " + e.getMessage());
		 }
	 }
	 catch (Exception e)
	 {
		 response.getWriter().println("Lỗi: " + e.getMessage());
	 }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
