package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DanhMucDAO;
import DAO.SanPhamDAO;
import model.DanhMuc;
import model.SanPham;

/**
 * Servlet implementation class ActionHanghoa
 */
@WebServlet("/actionhanghoa")
public class ActionHanghoa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActionHanghoa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
    	response.setCharacterEncoding("utf-8");
    	SanPhamDAO db = new SanPhamDAO();
		int MaHH = Integer.parseInt(request.getParameter("Ma"));
		
		String message ="";
		try
		{
			db.deleteSanPham(MaHH);
			message = "Xoá sản phẩm thành công.";
			RequestDispatcher xxx = request.getRequestDispatcher("hanghoa.jsp");
			request.setAttribute("msg", message );
			xxx.forward(request, response);
			
		}
		catch (Exception e)
		{
			message = "Xoá sản phẩm không thành công.";
			RequestDispatcher xxx = request.getRequestDispatcher("hanghoa.jsp");
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
    	SanPhamDAO db = new SanPhamDAO();
		
		String message ="";
		switch(action)
		{
		case "edit":
			try
			{
				int idd = Integer.parseInt(request.getParameter("ID"));
				String name = request.getParameter("tenhang");
				int soluong = Integer.parseInt(request.getParameter("sl"));
				int dgm = Integer.parseInt(request.getParameter("dgm"));
				int dgb = Integer.parseInt(request.getParameter("dgb"));
				int maloai = Integer.parseInt(request.getParameter("maloai"));
				SanPham sp = new SanPham(name,soluong,dgm,dgb,maloai);
				
	            try
	            {
	            	db.updateSanPham(idd, sp);    	
	            	message = "Sửa sản phẩm thành công.";
	            	RequestDispatcher xxx = request.getRequestDispatcher("hanghoa.jsp");
					request.setAttribute("msg1", message );
					xxx.forward(request, response);
	            	
	            }
	            catch(Exception e)
				{
	            	message = "Sửa sản phẩm không thành công 1.";
	            	RequestDispatcher xxx = request.getRequestDispatcher("hanghoa.jsp");
					request.setAttribute("msg1", message );
					xxx.forward(request, response);
				}
			}
			catch(Exception e)
			{
				message = "Sửa sản phẩm không thành công 2.";
	        	RequestDispatcher xxx = request.getRequestDispatcher("hanghoa.jsp");
				request.setAttribute("msg1", message );
				xxx.forward(request, response);
			}
			break;
		case "add":
			try
			{
				String tenhang = request.getParameter("tenhang");
				int soluong = Integer.parseInt(request.getParameter("sl"));
				int dgm = Integer.parseInt(request.getParameter("dgm"));
				int dgb = Integer.parseInt(request.getParameter("dgb"));
				int maloai = Integer.parseInt(request.getParameter("maloai"));
				SanPham sp = new SanPham(tenhang,soluong,dgm,dgb,maloai);
				
				
	            try
	            {
	            	db.insertSanPham(sp);
	            	
	            	message = "Thêm  sản phẩm thành công.";
	            	RequestDispatcher xxx = request.getRequestDispatcher("hanghoa.jsp");
					request.setAttribute("msg1", message );
					xxx.forward(request, response);
	            	
	            }
	            catch(Exception e)
				{
	            	message = "Thêm sản phẩm không thành công 1.";
	            	RequestDispatcher xxx = request.getRequestDispatcher("hanghoa.jsp");
					request.setAttribute("msg1", message );
					xxx.forward(request, response);
				}
			}
			catch(Exception e)
			{
				message = "Thêm sản phẩm không thành công 2.";
	        	RequestDispatcher xxx = request.getRequestDispatcher("hanghoa.jsp");
				request.setAttribute("msg1", message );
				xxx.forward(request, response);
			}
			break;
		default:
			break;	
		}
	}

}
