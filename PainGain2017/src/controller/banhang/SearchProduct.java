package controller.banhang;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SanPham;
import DAO.SanPhamDAO;

/**
 * Servlet implementation class SearchProduct
 */
@WebServlet("/searchproduct")
public class SearchProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        String str = request.getParameter("txtsearch");
        SanPhamDAO db = new SanPhamDAO();
        try {
            List<SanPham> rs = db.getLikeString(str);
            String strtext = "";
            for (SanPham hh : rs) {
                strtext += "<li class=\"suggest-col\" value=\"" + hh.getMaSp() + "\" onclick=\"addDetail(" + hh.getMaSp() + ");\">"
                        + "<span class=\"fa fa-tags fa-custom\"></span>"
                        + "<span class=\"fa-custom text-muted\">" + hh.getMaSp() + "</span>"
                        + "<span class=\"fa-custom text-muted\">" + hh.getTenSp() + "</span>"
                        + "<span class=\"fa-custom text-muted\">Đơn giá: <b>" + hh.getDonGiaBan() + "</b> VND</span>"
                        + "<span class=\"text-muted\">Số lượng hiện có: <b>" + hh.getSoLuong() + "</b></span>"
                        + "</li>";
            }
            response.getWriter().print(strtext);
        } catch (Exception ex) {
            response.getWriter().print("loi co so du lieu" + ex.getMessage());
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
