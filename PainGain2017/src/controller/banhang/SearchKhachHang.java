package controller.banhang;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.KhachHang;
import DAO.KhachHangDAO;

/**
 * Servlet implementation class SearchKhachHang
 */
@WebServlet("/searchkhachhang")
public class SearchKhachHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchKhachHang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        String str = request.getParameter("txtsearch");
        KhachHangDAO khaccessdb = new KhachHangDAO();
        try {
            List<KhachHang> rs = khaccessdb.getLikeString(str);
            String resulthtml = "";
            if (rs != null) {
                for (KhachHang kh : rs) {
                    resulthtml += "<li class=\"suggest-col\" onclick=\"addinfobill("+kh.getMaKh()+")\">"
                            + "<span class=\"fa  fa-user fa-custom\"></span>"
                            + "<span class=\"text-muted\">"+kh.getTenKh()+"</span>"
                            + "</li>";
                }
                response.getWriter().print(resulthtml);
            }else{
                response.getWriter().print("Không có kết quả nào");
            }
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
