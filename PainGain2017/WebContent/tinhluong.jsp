<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ page import="model.*" %>
<%@ page import="DAO.*" %>
<%@ page import="java.util.*" %>
<title>Quản Lý Tính Lương</title>
<%@include file="frame/header.jsp"%>
<%@include file="frame/sidebar.jsp"%>
<script language="javascript">
              function confirmAction() {
      		return confirm("Xác nhận xóa:")
	}
</script>
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
	<%
    Date dNow = new Date( );
    SimpleDateFormat ft = new SimpleDateFormat ("MM");
    String month =  ft.format(dNow);
    
    SimpleDateFormat ftt = new SimpleDateFormat ("yyyy-MM-dd");
    String date =  ftt.format(dNow);
    %>
		<h1>
			Quản lý tính lương tháng <%=month %>
		</h1>
		<ol class="breadcrumb">
			<li><a href="home.jsp"><i class="fa fa-dashboard"></i>Tháng: </a></li>
			<li>
					
						<select  id="inputText2"  name="month" onchange="location = this.value;" >
						<%
	                    	for(int i=1; i<13;i++)
	                    	{
	                    		
	                    		
	                    %>
	                     <option value="home.jsp"> Tháng <%=i %> </option> 
	                     
							
						<%} %>
						
						</select>
					
			</li>
			
		</ol>
	</section>
	<section class="content">
	<span style="color:red"><i id="msg"></i></span>
	<%
	
	List<CaLam> lstcl = new CaLamDAO().getAllCaLam();
	int soca = lstcl.size();
	int a[]=new int[soca+1]; // luong ca
	int b[]=new int[soca+1]; // so ca
	int c[]=new int[soca+1]; // so gio moi ca
	int i= 0;
	
		for (CaLam cl : lstcl)
		{
			a[i]=cl.getLuongGio();
			b[i]=cl.getMaCa();
			i++;
		}
	
	
	%>
		<div class="row">
	        <div class="col-xs-12">
	          <div class="box">
	            <div class="box-header">
	              <h3 class="box-title">Danh sách</h3>
	            </div>
	            <!-- /.box-header -->
	            <marquee behavior="scroll" direction="left" style="width: 100%; overflow-y: hidden;color : pink;">TRANG NÀY ĐANG TRONG QUÁ TRÌNH HOÀN THIỆN NỘI DUNG... HÃY THÔNG CẢM CHO DỊCH VỤ CỦA CHÚNG TÔI NHÉ. THẢ TIM. </marquee>
	            <div class="box-body">
	              <table id="example1" class="table table-striped table-bordered  table-hover">
	                <thead>
	                <tr>
	                  <th>Tên nhân viên</th>
	                  <th>Ca làm</th>
	                  <th>Số giờ làm / tháng</th>
	                  <th>Lương giờ /ca</th>
	                  <th>Thưởng</th>
	                  <th>Phạt</th>
	                  <th>Tổng lương</th>
	                </tr>
	                </thead>
	                <tbody>
	                <%
	                List<NhanVien> lstnv = new NhanVienDAO().getAllNhanVien();
	                for (NhanVien nv :lstnv)
	                {
	                	int thuong=0 , phat=0;
	               
	                %>
			                <tr>
			                  <td><br/><%=nv.getTenNv() %><br/></td>
			                  
			                  <td>
			                  		<%
			                  		for(i=0;i<soca;i++)
			                  		{
			                  			out.println("Ca "+b[i]);
			                  			%>
			                  			<br/>
			                  			<%
			                  		}
			                  		%>	
			                  </td>
			                  	<%
			                  	List<ChamCong> lstcc = new ChamCongDAO().getAllChamCong(nv.getMaNv(),date);
			                  	for(i=0;i<soca;i++)
			                  	{
			                  		c[i]=0;
			                  	}
			                  	for(i=0;i<soca;i++)
			                  	{
			                  		for(ChamCong cc:lstcc)
			                  		{
			                  			if(cc.getMaCa()==i+1)
			                  			{
			                  				int hour = 0;
			                  				hour = new TinhLuongDAO().Counthour(cc.getGioBatDau(), cc.getGioKetThuc());
			                  				c[i]+=hour/60;
			                  			}
			                  		}
			                  	}
			                  	%>
			                  <td>
			                  		<%
			                  		for( i=0;i<soca;i++)
			                  		{
			                  			out.println(c[i]);
			                  			%>
			                  			<br/>
			                  			<%
			                  		}
			                  		%>	
			                  </td>
			                  <td>
			                  	    <%
			                  		for( i=0;i<soca;i++)
			                  		{
			                  			out.println(a[i]);
			                  			%>
			                  			<br/>
			                  			<%
			                  		}
			                  		%>	
			                  </td>
			                  <%
			                  List<ThuongPhat> lsttp = new ThuongPhatDAO().getAllThuongPhat(nv.getMaNv(), date);
			                  for (ThuongPhat tp : lsttp)
			                  {
			                	  if(tp.getLaPhat()==1)
			                	  {
			                		  phat+=tp.getGiaTri();
			                	  }
			                	  else
			                	  {
			                		  thuong+=tp.getGiaTri();
			                	  }
			                  }
			                  %>
			                  <td><br/><%=thuong %><br/></td>
			                  <td><br/><%=phat %><br/></td>
			                  <%
			                  int luong = 0;
			                  for(i=0;i<soca;i++)
			                  {
			                	  luong+= a[i]*c[i];
			                  }
			                  luong+=thuong-phat;
			                  
			                  luong=luong/1000;
			                  int nluong= luong/1000;
			                  %>
			                  <td><br/><%=(nluong>0 || nluong<0) ? (nluong<0 ? nluong+"."+(-luong%1000) : nluong+"."+luong%1000) :luong %>.000 VNĐ<br/></td>
			                </tr>
	                
	                <% } %>
	                
	                
	                </tbody>
	                <tfoot>
	                 <tr>
	                  <th>Tên nhân viên</th>
	                  <th>Ca làm</th>
	                  <th>Số giờ làm / tháng</th>
	                  <th>Lương giờ /ca</th>
	                  <th>Thưởng</th>
	                  <th>Phạt</th>
	                  <th>Tổng lương</th>
	                </tr>
	                </tfoot>
	              </table>
	            </div>
	            <!-- /.box-body -->
	          </div>
	         </div>
         </div>
	</section>
</div>
<%@include file="frame/footer.jsp"%>