package controller.banhang;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.HoaDonSession;
import model.KhachHang;
import DAO.KhachHangDAO;

/**
 * Servlet implementation class AddCustomerOfBill
 */
@WebServlet("/addcustomerbill")
public class AddCustomerOfBill extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCustomerOfBill() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        int makh = Integer.parseInt(request.getParameter("maKH"));
        try {
            KhachHang kh = new KhachHangDAO().getKhachHang(makh);
            HttpSession session = request.getSession();
            HoaDonSession hoadon = (HoaDonSession) session.getAttribute("hoadon");
            if (hoadon == null) {
                response.sendRedirect(request.getContextPath() +"/createbill.jsp");
            } else {
                hoadon.setMaKh(kh.getMaKh());
                session.setAttribute("hoadon", hoadon);
                String resulthtml = "<strong>Họ tên</strong>"
                        + "<p class=\"text-muted\">" + kh.getTenKh() + "</p>"
                        + "<strong>Địa chỉ</strong>"
                        + "<p class=\"text-muted\">" + kh.getDiaChi() + "</p>"
                        + "<strong>Số điện thoại</strong>"
                        + "<p class=\"text-muted\">" + kh.getSoDt() + "</p>";
                response.getWriter().print(resulthtml);
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
