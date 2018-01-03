package controller.banhang;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ChiTietHoaDon;
import model.HoaDon;
import model.HoaDonSession;
import DAO.ChiTietHoaDonDAO;
import DAO.HoaDonDAO;

/**
 * Servlet implementation class saveBillDetail
 */
@WebServlet("/savebill")
public class saveBillDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public saveBillDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession();
        HoaDonSession hoadon = (HoaDonSession) session.getAttribute("hoadon");
        HoaDon hd = new HoaDon(hoadon.getNgayLap(),hoadon.getMaKh());
        ArrayList<ChiTietHoaDon> list = hoadon.getItems();
        String msg = "";
        HoaDonDAO hddao = new HoaDonDAO();
        ChiTietHoaDonDAO ctdao = new ChiTietHoaDonDAO();
        if (list.isEmpty()) {
            msg = "Không có sản phẩm nào trong hóa đơn";
        }else if(hoadon.getMaKh()==0){
            msg ="Không có khách hàng nào được chọn";
        } else if(!list.isEmpty()) {
            try {
                hddao.insertHoaDon(hd);
                for (ChiTietHoaDon ct : list) {
                    
                    ctdao.insertChiTietHoaDon(ct);
                    
                }
                session.setAttribute("hoadon", null);
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
