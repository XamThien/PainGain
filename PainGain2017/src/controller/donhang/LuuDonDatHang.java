package controller.donhang;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.*;

import DAO.*;

/**
 * Servlet implementation class LuuDonDatHang
 */
@WebServlet("/donhang/save")
public class LuuDonDatHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LuuDonDatHang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession();
        DonHang donhang = (DonHang) session.getAttribute("donhang");
        PhieuNhap dh = new PhieuNhap(donhang.getNgayLap());
        List<ChiTietPhieuNhap> list = donhang.getItems();
        String msg = "";
        PhieuNhapDAO dhdao = new PhieuNhapDAO();
        ChiTietPhieuNhapDAO ctdao = new ChiTietPhieuNhapDAO();
        if (list.isEmpty()) {
            msg = "Không có sản phẩm nào trong đơn hàng";
        } else if(!list.isEmpty()) {
            try {
                dhdao.insertPhieuNhap(dh);
                for (ChiTietPhieuNhap ct : list) {
                   
                    ctdao.insertChiTietPhieuNhap(ct);
                    
                }
                session.setAttribute("donhang", null);
                msg = "success";
            } catch (Exception ex) {
                msg = "loi: " + ex.getMessage();
            }
        }
        response.getWriter().print(msg);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
