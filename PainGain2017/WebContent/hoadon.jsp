<%-- 
    Document   : loai san pham
    Created on : Jun 11, 2017, 2:27:50 PM
    Author     : dangt
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@page import="java.text.*"%>
<%@page import="java.util.*"%>
<%@ page import="model.*" %>
<%@ page import="DAO.*" %>
<title>Hoá đơn bán hàng</title>
<%@include file="frame/header.jsp" %>
<script language="javascript">
              function confirmAction() {
      		return confirm("Xác nhận xóa:")
	}
</script>
<%@include file="frame/sidebar.jsp" %>
<div class="content-wrapper">
    <section class="content-header">
         <h1>
            Hoá đơn bán hàng
            
        </h1>
        <span style="color:red"><i>${msg}</i></span>
        <form class="formtlx" method="get" action="hoadon.jsp">
        <ul class="homeulstyle">
        	<li >Ngày:</li>
            <li><input type="date" class="rounded" name="viewdate" required="required"></li>
            <li class="active"><button type="submit" class="btn btn-link">Xem</button></li>
        </ul>
        </form>
    </section>
    <section class="content">
    	<span style="color:red"><i>${msg1}</i></span>
    	
          <div class="box">
            <!-- /.box-header -->
            <div class="box-body">
              <table id="example1" class="table table-bordered table-striped table-hover">
                <thead>
                <tr>
                  <th>Mã hoá đơn</th>
                  <th>Ngày lập</th>
                  <th>Khách hàng</th>
                  <th>Số điện thoại</th>
                  <th></th>
                </tr>
                </thead>
                <tbody>
                <%
                String dayx= null;
    			dayx= request.getParameter("viewdate");
    			SimpleDateFormat fttt = new SimpleDateFormat ("yyyy-MM-dd");
    			List<HoaDon> lst = null;
    			if(dayx==null)
			    {
    				lst =  new  HoaDonDAO().getAllHoaDon();
			    }
			    else
			    {
			    	Date d1 = null;
				    d1 = fttt.parse(dayx);
			    	String date= fttt.format(d1);
			    	lst =  new  HoaDonDAO().getOnDayHoaDon(date);
			    }
               
                	if (lst != null) 
                	{
                		for (HoaDon hd : lst)
                		{
                			KhachHang kh = new KhachHangDAO().getKhachHang(hd.getMaKh());
                %>
                <tr>
                    <td><a href="#" title="click vào để xem chi tiết"><%=hd.getMaHd() %></a></td>
                    <td><%=hd.getNgayLap() %></td>
                   	<td><%=kh.getTenKh() %></td>
                   	<td><%=kh.getSoDt() %></td>
                   	<td>
                      <a href="chitiethoadon.jsp?MaHD=<%=hd.getMaHd()%>">Chi tiết</a>
                    </td>
                  </tr>
                   <%
                		}
                	}
                   %>
                   
                   
                </tbody>
                <tfoot>
                <tr>
                  <th>Mã hoá đơn</th>
                  <th>Ngày lập</th>
                  <th>Khách hàng</th>
                  <th>Số điện thoại</th>
                  <th></th>
                </tr>
                </tfoot>
              </table>
            </div>
    
            <!-- /.box-body -->
          </div>
         
        
      
    </section>
    <!-- =============================================================================== -->
  
 

  <!-- ===============================================================================  -->
</div>
<%@include file="frame/footer.jsp" %>
