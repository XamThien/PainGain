package controller.donhang;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;


import model.*;
import DAO.*;

/**
 * Servlet implementation class ThemChiTietDonHang
 */

public class ThemChiTietDonHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemChiTietDonHang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        int mahh = Integer.parseInt(request.getParameter("maHH"));
        HttpSession session = request.getSession();
        DonHang donhang = (DonHang) session.getAttribute("donhang");
        try {
            SanPham hh = new SanPhamDAO().getSanPham(mahh);
            long total = 0;
            //NhaccSanpham getNhaccByIdSanpham  new NhaccSanphamDAO().getNhaccByIdSanpham(hh.getMaSp()).getMaNcc()
            String txtresult = "";
            if (donhang == null) {
                response.sendRedirect(request.getContextPath() +"/addondh.jsp");
            } else {
            	PhieuNhap pn = new PhieuNhapDAO().getLastPhieuNhap();
            	ChiTietPhieuNhap ct = new ChiTietPhieuNhap(pn.getMaPn()+1, mahh, hh.getDonGiaMua(),1, new NhaccSanphamDAO().getNhaccByIdSanpham(hh.getMaSp()).getMaNcc());
                donhang.addItem(ct);
                session.setAttribute("donhang", donhang);
                List<ChiTietPhieuNhap> rs = donhang.getItems();
                int i = 1;
                for (ChiTietPhieuNhap ctiet : rs) {
                    long money = ctiet.getSoLuong() * ctiet.getDonGia();
                    total += money;
                    String tensp = new SanPhamDAO().getSanPham(ctiet.getMaSp()).getTenSp();
                    txtresult += "<tr for=\"" + ctiet.getMaSp() + "\">"
                            + "<td>" + i + "</td>"
                            + "<td>" + ctiet.getMaSp() + "</td>"
                            + "<td>" + tensp + "</td>"
                            + "<td><input type=\"text\" name=\"dongia\" class=\"form-control dongia\" value=\"" + ctiet.getDonGia() + "\" onchange=\"donhangEdit(this);\"></td>"
                            + "<td><input type=\"number\" name=\"soluong\" class=\"form-control soluong\" value=\"" + ctiet.getSoLuong() + "\" onchange=\"donhangEdit(this);\"></td>"
                            + "<td>" + money + "</td>"
                            + "<td><a href=\"#\" onclick=\"confirmDHRemove("+ ctiet.getMaSp() +");\"><span  class=\" fa fa-times-circle delproc\" ></span></a></td>"
                            + "</tr>";
                    i++;
                }
            }
            JSONObject obj = new JSONObject();
            obj.put("list", txtresult);
            obj.put("total", total);
            response.getWriter().print(obj.toJSONString());
        } catch (Exception ex) {
            Logger.getLogger(ThemChiTietDonHang.class.getName()).log(Level.SEVERE, null, ex);
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
