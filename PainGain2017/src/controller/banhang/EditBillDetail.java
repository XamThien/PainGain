package controller.banhang;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import model.ChiTietHoaDon;
import model.HoaDon;
import model.HoaDonSession;
import model.SanPham;
import DAO.HoaDonDAO;
import DAO.SanPhamDAO;

/**
 * Servlet implementation class EditBillDetail
 */
@WebServlet("/editbill")
public class EditBillDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBillDetail() {
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
        int giamgia = Integer.parseInt(request.getParameter("GiamGia"));
        
        
        SanPham sp = new SanPhamDAO().getSanPham(mahh);
        
        if (dongia<=0) {dongia= sp.getDonGiaBan();}
        if(soluong<=0) {soluong=1;}
        if(giamgia<0) {giamgia=0;}
        
        HttpSession session = request.getSession();
        HoaDonSession hoadon = (HoaDonSession) session.getAttribute("hoadon");
        ChiTietHoaDon ct = hoadon.getItem(mahh);
        ct.setDonGia(dongia);
        
        ct.setGiamGia(giamgia);
        ct.setSoLuong(soluong);
        
        hoadon.update(ct);
        session.setAttribute("hoadon", hoadon);
        try {
            String txtresult = "";
            ArrayList<ChiTietHoaDon> rs = hoadon.getItems();
            int i = 1;
            long totalbill = 0;
            for (ChiTietHoaDon ctiet : rs) {
                String tensp = new SanPhamDAO().getSanPham(ctiet.getMaSp()).getTenSp();
                int total = (int) (ctiet.getDonGia() * ctiet.getSoLuong() - ctiet.getDonGia() * ctiet.getSoLuong() * ctiet.getGiamGia() * 0.01);
                txtresult += "<tr for=\"" + ctiet.getMaSp() + "\">"
                        + "<td>" + i + "</td>"
                        + "<td>" + ctiet.getMaSp() + "</td>"
                        + "<td>" + tensp + "</td>"
                        + "<td><input type=\"text\" class=\"form-control dongia\" value=\""+ctiet.getDonGia()+"\" onchange= \"editBill(this);\"></td>"
                        + "<td><input type=\"number\" class=\"form-control soluong\" value=\"" + ctiet.getSoLuong() + "\" onchange= \"editBill(this);\"></td>"
                        + "<td><input type=\"number\" class=\"form-control giamgia\" value=\"" + ctiet.getGiamGia() + "\" onchange= \"editBill(this);\"></td>"
                        + "<td>" + total + "</td>"
                        + "<td><a href=\"#\" onclick=\"confirmremove(\'"+ ctiet.getMaSp() +"\');\"><span  class=\" fa fa-times-circle delproc\"></span></a></td>"
                        + "</tr>";
                i++;
                totalbill += total;
            }
            JSONObject jsonobject = new JSONObject();
            jsonobject.put("list", txtresult);
            jsonobject.put("total", Long.toString(totalbill));
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
