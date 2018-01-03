package controller.donhang;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;
import DAO.*;

/**
 * Servlet implementation class SuggestSanPham
 */

public class SuggestSanPham extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuggestSanPham() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html; charset=UTF-8");
	        request.setCharacterEncoding("utf-8");
	        String str = request.getParameter("txtsearch");
	        try {
	            List<SanPham> list = new SanPhamDAO().getLikeString(str);
	            String strtext="";
	            for(SanPham hh:list){
	                strtext += "<li class=\"suggest-col\" value=\"" + hh.getMaSp() + "\" onclick=\"dhthemSanpham(" + hh.getMaSp() + ");\">"
	                        + "<span class=\"fa fa-tags fa-custom\"></span>"
	                        + "<span class=\"fa-custom text-muted\">" + hh.getMaSp() + "</span>"
	                        + "<span class=\"fa-custom text-muted\">" + hh.getTenSp() + "</span>"
	                        + "<span class=\"fa-custom text-muted\">Đơn giá nhập: <b>" + hh.getDonGiaMua() + "</b> VND</span>"
	                        + "<span class=\"text-muted\">Số lượng hiện có: <b>" + hh.getSoLuong() + "</b></span>"
	                        + "</li>";
	            }
	            response.getWriter().print(strtext);
	        } catch (Exception ex) {
	            response.getWriter().print(ex.getMessage());
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
