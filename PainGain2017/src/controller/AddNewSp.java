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
 * Servlet implementation class AddNewSp
 */
@WebServlet("/addnewsp")
public class AddNewSp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewSp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		try
		{
			String tenSP = request.getParameter("tenhang");
			int sl = Integer.parseInt(request.getParameter("sl"));
			int giamua = Integer.parseInt(request.getParameter("dgm"));
			int giaban = Integer.parseInt(request.getParameter("dgb"));
			int maloai = Integer.parseInt(request.getParameter("maloai"));
			
			SanPhamDAO db = new SanPhamDAO();
			String message="";
			
			try
			{
				SanPham sp = new SanPham(tenSP,sl,giaban,giamua,maloai);
				db.insertSanPham(sp);
				message = " Thêm mới sản phẩm thành công.";
				RequestDispatcher xxx = request.getRequestDispatcher("addNewSP.jsp");
				request.setAttribute("msg", message );
				xxx.forward(request, response);
			}
			catch(Exception e)
			{
				message = "Thêm mới sản phẩm không thành công.";
				RequestDispatcher xxx = request.getRequestDispatcher("addNewSP.jsp");
				request.setAttribute("msg", message );
				xxx.forward(request, response);
			}
		}
		catch(Exception ex)
		{
			String message = "Thêm mới sản phẩm không thành công.";
			RequestDispatcher xxx = request.getRequestDispatcher("addNewSP.jsp");
			request.setAttribute("msg", message );
			xxx.forward(request, response);
		}
	}

}
