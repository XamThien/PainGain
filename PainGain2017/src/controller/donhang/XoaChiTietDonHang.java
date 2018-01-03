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

import org.json.simple.JSONObject;

import model.*;
import DAO.*;

/**
 * Servlet implementation class XoaChiTietDonHang
 */
@WebServlet("/donhang/remove")
public class XoaChiTietDonHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XoaChiTietDonHang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        int mahh = Integer.parseInt(request.getParameter("MaHH"));
        HttpSession session = request.getSession();
        DonHang donhang = (DonHang) session.getAttribute("donhang");
        ChiTietPhieuNhap ct = donhang.getItem(mahh);
        donhang.remove(ct);
        session.setAttribute("donhang", donhang);
        try {
            List<ChiTietPhieuNhap> rs = donhang.getItems();
            int i = 1;
            long totalbill = 0;
            String txtresult = "";
            for (ChiTietPhieuNhap ctiet : rs) {
            	String tensp = new SanPhamDAO().getSanPham(ctiet.getMaSp()).getTenSp();
                
                long total = ctiet.getDonGia() * ctiet.getSoLuong();
                txtresult += "<tr for=\"" + ctiet.getMaSp() + "\">"
                        + "<td>" + i + "</td>"
                        + "<td>" + ctiet.getMaSp() + "</td>"
                        + "<td>" + tensp + "</td>"
                        + "<td><input type=\"text\" name=\"dongia\" class=\"form-control dongia\" value=\"" + ctiet.getDonGia() + "\" onchange=\"donhangEdit(this);\"></td>"
                        + "<td><input type=\"number\" name=\"soluong\" class=\"form-control soluong\" value=\"" + ctiet.getSoLuong() + "\" onchange=\"donhangEdit(this);\"></td>"
                        + "<td>" + total + "</td>"
                        + "<td><a href=\"#\" onclick=\"confirmDHRemove(" + ctiet.getMaSp() + ");\"><span  class=\" fa fa-times-circle delproc\" ></span></a></td>"
                        + "</tr>";
                i++;
                totalbill += total;
            }
            if (txtresult.isEmpty()) {
                txtresult = "Không có sản phẩm nào được chọn";
            }
            JSONObject obj = new JSONObject();
            obj.put("list", txtresult);
            obj.put("total", totalbill);
            response.getWriter().print(obj.toJSONString());
        } catch (Exception e) {
            response.getWriter().print("loi: " + e.getMessage());
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
