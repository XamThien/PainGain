package controller.donhang;

import java.io.IOException;
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
 * Servlet implementation class SuaChiTietDonHang
 */
@WebServlet("/donhang/edit")
public class SuaChiTietDonHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaChiTietDonHang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        int dongia = Integer.parseInt(request.getParameter("DonGia"));
        int mahh = Integer.parseInt(request.getParameter("MaHH"));
        int soluong = Integer.parseInt(request.getParameter("SoLuong"));

        HttpSession session = request.getSession();
        DonHang donhang = (DonHang) session.getAttribute("donhang");
        ChiTietPhieuNhap ct = donhang.getItem(mahh);
        ct.setDonGia(dongia);
        if (soluong<=0) {soluong=1;}
        ct.setSoLuong(soluong);
        donhang.update(ct);
        session.setAttribute("donhang", donhang);
        try {
            String txtresult = "";
            List<ChiTietPhieuNhap> rs = donhang.getItems();
            int i = 1;
            long totalbill = 0;
            for (ChiTietPhieuNhap ctiet : rs) {
            	String tensp = new SanPhamDAO().getSanPham(ctiet.getMaSp()).getTenSp();
                int total = ctiet.getDonGia() * ctiet.getSoLuong();
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
            JSONObject jsonobject = new JSONObject();
            jsonobject.put("list", txtresult);
            jsonobject.put("total", totalbill);
            response.getWriter().print(jsonobject.toJSONString());
        } catch (Exception ex) {
            response.getWriter().print("loi: " + ex.getMessage());
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
