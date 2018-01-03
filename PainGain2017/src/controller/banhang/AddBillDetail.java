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
import model.SanPham;
import model.HoaDonSession;
import DAO.HoaDonDAO;
import DAO.SanPhamDAO;

/**
 * Servlet implementation class AddBillDetail
 */
@WebServlet("/addchitiethoadon")
public class AddBillDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBillDetail() {
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
        
        HoaDon hd = new HoaDonDAO().getLastHoaDon();
       
        
        try {
        	SanPham hh = new SanPhamDAO().getSanPham(mahh);
            HttpSession session = request.getSession();
            HoaDonSession hoadon = (HoaDonSession) session.getAttribute("hoadon");
            if (hoadon == null) {
                response.sendRedirect(request.getContextPath() +"/createbill.jsp");
            } else {
                ChiTietHoaDon ct = new ChiTietHoaDon(hd.getMaHd()+1, mahh,1, 0,0,true);
                if(hoadon.isDuplicateMa(mahh) == -1)
                {
                	ct.setDonGia(hh.getDonGiaBan());
                }
                hoadon.addItem(ct);
                session.setAttribute("hoadon", hoadon);
                String txtresult = "";
                ArrayList<ChiTietHoaDon> rs = hoadon.getItems();
                if (rs.size()==1)
                {
                	ct.setDonGia(hh.getDonGiaBan());
                }
                int i=1;
                long totalbill=0 ;
                for (ChiTietHoaDon ctiet : rs) {
                    String tensp = new SanPhamDAO().getSanPham(ctiet.getMaSp()).getTenSp();
                    //
                    long total = (ctiet.getDonGia() * ctiet.getSoLuong()) -((ctiet.getDonGia()* ctiet.getSoLuong())*ctiet.getGiamGia())/100;
                    txtresult += "<tr for=\""+ctiet.getMaSp()+"\">"
                            + "<td>"+i+"</td>"
                            + "<td>"+ctiet.getMaSp()+"</td>"
                            + "<td>"+tensp+"</td>"
                            + "<td><input type=\"text\" class=\"form-control dongia\" value=\""+ctiet.getDonGia()+"\" onchange= \"editBill(this);\"></td>"
                            + "<td><input type=\"number\" class=\"form-control soluong\" value=\""+ctiet.getSoLuong()+"\" onchange= \"editBill(this);\"></td>"
                            + "<td><input type=\"number\" class=\"form-control giamgia\" value=\""+ctiet.getGiamGia()+"\" onchange= \"editBill(this);\"></td>"
                            + "<td>"+total+"</td>"
                            + "<td><a href=\"#\" onclick=\"confirmremove(\'"+ ctiet.getMaSp() +"\');\"><span  class=\" fa fa-times-circle delproc\" ></span></a></td>"
                            + "</tr>";
                    i++;
                    totalbill+=total;
                }
                JSONObject jsonobject = new JSONObject();
                jsonobject.put("list", txtresult);
                jsonobject.put("total",Long.toString(totalbill));
                response.getWriter().print(jsonobject.toJSONString());
            }
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
