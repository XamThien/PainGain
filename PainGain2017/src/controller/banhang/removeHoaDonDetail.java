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
import model.HoaDonSession;
import model.SanPham;
import DAO.SanPhamDAO;

/**
 * Servlet implementation class removeHoaDonDetail
 */
@WebServlet("/removechitiethoadon")
public class removeHoaDonDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public removeHoaDonDetail() {
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
        HoaDonSession hoadon = (HoaDonSession) session.getAttribute("hoadon");
        ChiTietHoaDon ct = hoadon.getItem(mahh);
        hoadon.remove(ct);
        session.setAttribute("hoadon", hoadon);
        try {
        	SanPham sp = new SanPhamDAO().getSanPham(mahh);
            ArrayList<ChiTietHoaDon> rs = hoadon.getItems();
            int i=1;
                long totalbill=0 ;
                String txtresult="";
                for (ChiTietHoaDon ctiet : rs) {
                    String tensp = new SanPhamDAO().getSanPham(ctiet.getMaSp()).getTenSp();
                    long total = (ctiet.getDonGia() * ctiet.getSoLuong()) -((ctiet.getDonGia()* ctiet.getSoLuong())*ctiet.getGiamGia())/100;
                    txtresult += "<tr for=\""+ctiet.getMaSp()+"\">"
                            + "<td>"+i+"</td>"
                            + "<td>"+ctiet.getMaSp()+"</td>"
                            + "<td>"+tensp+"</td>"
                            + "<td><input type=\"text\" class=\"form-control dongia\" value=\""+sp.getDonGiaBan()+"\" onchange= \"editBill(this);\"></td>"
                            + "<td><input type=\"number\" class=\"form-control soluong\" value=\""+ctiet.getSoLuong()+"\" onchange= \"editBill(this);\"></td>"
                            + "<td><input type=\"number\" class=\"form-control giamgia\" value=\""+ctiet.getGiamGia()+"\" onchange= \"editBill(this);\"></td>"
                            + "<td>"+total+"</td>"
                            + "<td><a href=\"#\" onclick=\"confirmremove(\'"+ ctiet.getMaSp() +"\');\"><span  class=\" fa fa-times-circle delproc\"></span></a></td>"
                            + "</tr>";
                    i++;
                    totalbill+=total;
                }
                if(txtresult.isEmpty()){
                    txtresult ="Không có sản phẩm nào được chọn";
                }
                JSONObject obj = new JSONObject();
                obj.put("list", txtresult);
                obj.put("total", totalbill);
                response.getWriter().print(obj.toJSONString());
        } catch (Exception e) {
            response.getWriter().print("loi: "+ e.getMessage());
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
