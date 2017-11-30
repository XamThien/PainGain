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

import DAO.*;
import model.*;

/**
 * Servlet implementation class AddThuongphat
 */
@WebServlet("/addthuongphat")
public class AddThuongphat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddThuongphat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		int lathuong ;
		int laphat ;
		
		int giatri = Integer.parseInt(request.getParameter("giatri"));
		int hinhthuc = Integer.parseInt(request.getParameter("hinhthuc"));
		int ma_nv = Integer.parseInt(request.getParameter("ID"));
		String lido = request.getParameter("lido");
		if(hinhthuc==1)
		{
			lathuong = 1;
			laphat = 0;
		}
		
		else {
			lathuong = 0;
			laphat =1;
		}
		
        String message ="";
        
        Date Ngay = new Date();
        SimpleDateFormat datefrmat = new SimpleDateFormat("yyyy-MM-dd");
        String datestr = datefrmat.format(Ngay);
        
        ThuongPhatDAO db = new ThuongPhatDAO();
    	ThuongPhat tp = new ThuongPhat(giatri,datestr,lathuong,laphat,lido,ma_nv);
        
        try
        {
        		db.insertThuongPhat(tp);;
        		message = "Thêm mới thành công.";
    			RequestDispatcher xxx = request.getRequestDispatcher("thuongphat.jsp");
    			request.setAttribute("msg", message );
    			xxx.forward(request, response);
        	
        }
        catch (Exception x)
        {
        	message = "Không thành công.";
			RequestDispatcher xxx = request.getRequestDispatcher("thuongphat.jsp");
			request.setAttribute("msg", message );
			xxx.forward(request, response);
        }
	}

}
