package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.*;
import model.*;
/**
 * Servlet implementation class AddChamcong
 */
@WebServlet("/addchamcong")
public class AddChamcong extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddChamcong() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String giobd = request.getParameter("gbd");
		String giokt = request.getParameter("gkt");
		int ma_ca = Integer.parseInt(request.getParameter("ma_ca"));
		int ma_nv = Integer.parseInt(request.getParameter("ID"));
		
        String message ="";
        
        Date Ngay = new Date();
        SimpleDateFormat datefrmat = new SimpleDateFormat("yyyy-MM-dd");
        String datestr = datefrmat.format(Ngay);
        
        try
        {
        	try
        	{
        		ChamCongDAO db = new ChamCongDAO();
            	ChamCong cc = db.getChamCong(ma_nv,datestr,ma_ca);
            	if (cc==null)
            	{
            		ChamCong ccn = new ChamCong(ma_nv,giobd,giokt,datestr,ma_ca);
            		db.insertChamCong(ccn);
            		message = "Chấm công thành công.";
        			RequestDispatcher xxx = request.getRequestDispatcher("chamcong.jsp");
        			request.setAttribute("msg", message );
        			xxx.forward(request, response);
            	}
            	else
            	{
            		message = "Bạn đã chấm công hôm nay.";
        			RequestDispatcher xxx = request.getRequestDispatcher("chamcong.jsp");
        			request.setAttribute("msg", message );
        			xxx.forward(request, response);
            	}
        	}
        	catch (Exception y)
        	{
        		System.out.println(y);
            	message = "Không thành công.";
    			RequestDispatcher xxx = request.getRequestDispatcher("chamcong.jsp");
    			request.setAttribute("msg", message );
    			xxx.forward(request, response);
        	}
        }
        catch (Exception x)
        {
        	System.out.println(x);
        	message = "Không thành công.";
			RequestDispatcher xxx = request.getRequestDispatcher("chamcong.jsp");
			request.setAttribute("msg", message );
			xxx.forward(request, response);
        }
		
		
	}

}
